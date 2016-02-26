/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.*;
import domain.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
//import dao.MemberJdbcDAO;

/**
 * 
 * Web-based system for Otago Southland Chinese Association (OSCA)
 * 
 * @author Jill Mirandilla, Kendall Chin, Gary Lee, Sean Braid and Hans To'o
 */
@WebServlet(name = "CreateNewAccount", urlPatterns = {"/CreateNewAccount"})
public class CreateNewAccount extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            
            /* Member details*/
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            //String postCode = request.getParameter("postCode");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String[] interests = request.getParameterValues("involvement");
            String subscriptionType = request.getParameter("subscriptionType");
            String status = "P";
            String eligibility = request.getParameter("eligibility");
            /* Partner */
            String pFirstName = request.getParameter("partnerFirstName");
            String pLastName = request.getParameter("partnerLastName");
            String pAddress = request.getParameter("partnerAddress");
            //String pCode = request.getParameter("partnerPostCode");
            String pPhone = request.getParameter("partnerPhone");
            String pEmail = request.getParameter("partnerEmail");
            String[] pInterest = request.getParameterValues("partnerInvolve");
            String pStatus = "P";
            String pEligibility = request.getParameter("pEligibility");

            /* Siblings */

            
            /* Child */
            
            Member member = new Member();
            Member partner = new Member();
            MemberJdbcDAO dao = new MemberJdbcDAO();
            //Generate id number
            int length = 7;
            Random random = new Random();
            char[] digits = new char[length];
            digits[0] = (char) (random.nextInt(9) + '1');
            for (int i = 1; i < length; i++) {
                
                digits[i] = (char) (random.nextInt(10) + '0');
            }
            
            member.setId(Integer.parseInt(new String(digits)));
            member.setFirstName(firstName);
            member.setLastName(lastName);
            member.setAddress(address);
            member.setPhoneNumber(phone);
            member.setEmail(email);
            member.setSubscription(subscriptionType); 
            member.setEligibility(eligibility);
            //System.out.println(Arrays.toString(interests));
            if(interests != null){
                for(String i : interests){
                    member.setCatagories(i);
                }
            }
            
            //member.setCatagories(Arrays.toString(interests));
            member.setStatus(status);
            
            // Partner 
            if(pFirstName != null){
                member.setPartnersName(pFirstName +" "+ pLastName);
                partner.setId(Integer.parseInt(new String(idGenerator())));
                partner.setFirstName(pFirstName);
                partner.setLastName(pLastName);
                partner.setAddress(pAddress);
                partner.setPhoneNumber(pPhone);
                partner.setEmail(pEmail);
                partner.setSubscription(subscriptionType);
                if(pInterest != null){
                    for(String pI : pInterest){
                        partner.setCatagories(pI);
                    }
                }
                //partner.setCatagories(Arrays.toString(pInterest));
                partner.setPartnersName(firstName +" " + lastName);
                partner.setStatus(pStatus);
                partner.setEligibility(pEligibility);
            }
            
            boolean s = true;
            int num = 1;
            ArrayList<String> siblingNames = new ArrayList<>(); //member's sibling
            ArrayList<Integer> siblingList = new ArrayList<>();
            ArrayList<Member> siblings = new ArrayList<>();
            
            while(s != false){
                if(request.getParameter("siblingFirstName" + num) != null){
                    String sFirstName = request.getParameter("siblingFirstName" + num);
                    String sLastName = request.getParameter("siblingLastName" + num);
                    String sAddress = request.getParameter("siblingAddress" + num);
                    String sPhone = request.getParameter("siblingPhone" + num);
                    String sEmail = request.getParameter("siblingEmail" + num);
                    String[] sInvolve = request.getParameterValues("siblingInvolve" + num);
                    String sStatus = "P";
                    String sEligibility = request.getParameter("sEligibility" + num);
                    //siblings brother or sister list 
                    //ArrayList<String> siblingList = new ArrayList<>();
                    
                    siblingNames.add(sFirstName);
                    //siblingList.add(firstName);
                    Member sibling = new Member();
                    sibling.setId(Integer.parseInt(new String(idGenerator())));
                    sibling.setFirstName(sFirstName);
                    sibling.setLastName(sLastName);
                    sibling.setAddress(sAddress);
                    sibling.setPhoneNumber(sPhone);
                    sibling.setEmail(sEmail);
                    sibling.setSubscription(subscriptionType);
                    sibling.setEligibility(sEligibility);
                    if(sInvolve != null){
                        for(String sI : sInvolve){
                            sibling.setCatagories(sI);
                        }
                    }
                    //sibling.setCatagories(Arrays.toString(sInvolve));
                    sibling.setSiblingsName(firstName + lastName);
                    sibling.setStatus(sStatus);
                    siblingList.add(sibling.getId());
                    //dao.save(sibling);
                    siblings.add(sibling);
                    //dao.saveSibling(sibling);
                    num++;
                } else {
                    s = false;
                }
            }
            boolean c = true;
            int numC = 1;
            ArrayList<String> childNames = new ArrayList<>();
            ArrayList<Member> children = new ArrayList<>();
            
            while(c != false){
                if(request.getParameter("childFirstName" + numC) != null){
                    String cFirstName = request.getParameter("childFirstName" + numC);
                    String cLastName = request.getParameter("childLastName" + numC);
                    String cAddress = request.getParameter("childAddress" + numC);
                    String cPhone = request.getParameter("childPhone" + numC);
                    String cEmail = request.getParameter("childEmail" + numC);
                    String[] cInvolve = request.getParameterValues("childrenInvolve" + numC);
                    String cStatus = "P";
                    String cEligibility = request.getParameter("cEligibility" + numC);
                    
                    Member child = new Member();
                    childNames.add(cFirstName);
                    child.setId(Integer.parseInt(new String(idGenerator())));
                    child.setFirstName(cFirstName);
                    child.setLastName(cLastName);
                    child.setAddress(cAddress);
                    child.setPhoneNumber(cPhone);
                    child.setEmail(cEmail);
                    child.setSubscription(subscriptionType);
                    child.setEligibility(cEligibility);
                    if(cInvolve != null){
                        for(String cI : cInvolve){
                            child.setCatagories(cI);
                        }
                    }
                    //child.setCatagories(Arrays.toString(cInvolve));
                    child.setStatus(cStatus);
                    //dao.save(child);
                    children.add(child);
                    //dao.saveChildren(child);
                    numC++;
                } else{
                    c = false;
                }
            }
            member.setChildrenName(childNames.toString());
            member.setSiblingsName(siblingNames.toString());
            //if member has any siblings
            
            for(Member mem : siblings){
                //System.out.println(mem.getFirstName());
                ArrayList<String> allSiblings = new ArrayList<>();
                allSiblings.add(member.getFirstName());
                for(String sb : siblingNames){
                    if(!sb.equals(mem.getFirstName())){
                        allSiblings.add(sb);
                    }
                }
                mem.setSiblingsName(allSiblings.toString());
                dao.save(mem);
            }
            
            for(Member mc : children) {
              //System.out.println(mc.getFirstName());
              ArrayList<String> allChildren = new ArrayList<>();
              for (String ch : childNames) {
                  if(!ch.equals(mc.getFirstName())) {
                      allChildren.add(ch);
                  }
              }
              mc.setSiblingsName(allChildren.toString());
              dao.save(mc);
             }
            
            
            //siblingList.
            if(partner.getFirstName() != null){
                partner.setChildrenName(childNames.toString());
                
                //dao.savePartner(partner);
                dao.save(partner);
            }
            dao.save(member);
           
            response.sendRedirect("/info221-phase2/followUpPage.html");
        } finally {
            out.close();
        }
    }
    
    public static char[] idGenerator(){
        int length = 7;
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
                
               digits[i] = (char) (random.nextInt(10) + '0');
            }       
        return digits;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
