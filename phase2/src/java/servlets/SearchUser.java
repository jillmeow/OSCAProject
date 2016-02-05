/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.MemberJdbcDAO;
import domain.Member;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.apache.catalina.tribes.util.Arrays;

/**
 *
 * @author mirji507
 */
@WebServlet(name = "SearchUser", urlPatterns = {"/SearchUser"})
public class SearchUser extends HttpServlet {

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
            MemberJdbcDAO dao = new MemberJdbcDAO();
            /* TODO output your page here. You may use following sample code. */
            //Collection<Member> m = dao.getAll();
            
            //System.out.println(Arrays.toString(m.toArray()));
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"style.css\">");
            out.println("<title>OSCA: Otago Chinese Association</title>");            
            out.println("</head>");
            out.println("<header>\n" +
"                <div id=\"logo\">\n" +
"                        <img src=\"logo.jpg\" alt=\"The New Zealand Chinese Association, Otago and Southland Branch Logo\">\n" +
"                </div>\n" +
"             \n" +
"                <nav id=\"menu\">\n" +
"                    <ul>\n" +
"                        <li class=\"links\">\n" +
"                            <a href=\"index.html\">\n" +
"                                Home\n" +
"                            </a>\n" +
"                        </li>\n" +
"                        <li class=\"links\">\n" +
"                            <a href=\"membership.html\">\n" +
"                                Membership\n" +
"                            </a>\n" +
"                        </li>\n" +
"                        <li class=\"links\">\n" +
"                            <a>\n" +
"                                Search\n" +
"                            </a>\n" +
"                        </li>\n" +
"                    </ul>\n" +
"                </nav>\n" +
"            </header>");
            out.println("<body>");
            out.println("<div id=\"search\" style=\"float: left;\">\n" +
"            <h2>Search Members</h2>\n" +
"        <form action=\"/info221-phase2/SearchUser\" method=\"get\">\n" +
"            Search User: <input type=\"text\" name=\"name\">\n" +
"            <input type=\"submit\">\n" +
"        </form>\n" +
"            <h3>Search Result</h3>\n" +
"            <p> User "
                    + request.getParameter("name")+"</p>\n" +
               dao.getAll()+
"        </div>");
            
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
