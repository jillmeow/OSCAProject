/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Admin;
import domain.Member;
import domain.Payment;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import utils.MultiMap;

/**
 * 
 * Web-based system for Otago Southland Chinese Association (OSCA)
 * 
 * @author Jill Mirandilla, Kendall Chin, Gary Lee, Sean Braid and Hans To'o
 */
public class MemberCollectionDAO implements MemberDAO {
    
    private static final TreeSet<Member> members = new TreeSet<>();
    private static final TreeSet<Payment> payments = new TreeSet<>();
    private static final Set categories = new HashSet();
    private static final Set status = new HashSet();
    private static final Set child = new HashSet();
    private static final Set sibling = new HashSet();
    private static final Set partner = new HashSet();
    private static final SortedMap<Integer, Member> byId = new TreeMap<>();
    private static final MultiMap<String, Member> map = new MultiMap<>();
    private static final MultiMap<String, Member> mapStatus = new MultiMap<>();
    private static final SortedMap<Integer, Payment> paymentID = new TreeMap<>();
    
    @Override
    public void save(Member aMember) {
        members.add(aMember);
        categories.add(aMember.getCatagories());
        status.add(aMember.getStatus());
        byId.put(aMember.getId(), aMember);
        map.put(aMember.getCatagories().toString(), aMember);
        mapStatus.put(aMember.getStatus().toString(), aMember);
    }
    
    @Override
    public Collection<Member> getAll() {
        return members;
    }
    
    @Override
    public Collection<String> getCategories() {
        return categories;
    }

    @Override
    public Collection<String> getStatus() {
        return categories;
    }

    @Override
    public void delete(Member aMember) {
        members.remove(aMember);
        categories.remove(aMember.getCatagories());
        map.remove(aMember.getCatagories().toString(), aMember);
        byId.remove(aMember.getId());
    }
    
    public void deleteChild() {
        members.removeAll(child);
        
    }
    
    public void deleteSibling() {
        
        members.removeAll(sibling);
    }
    
    public void deletePartner() {
        
        members.removeAll(partner);
    }
    
    @Override
    public Member getById(Integer aId) {
        return byId.get(aId);
    }
    
    @Override
    public Collection<Member> getByCategories(String aCategory) {
        return map.get(aCategory);
    }
    
    @Override
    public Collection<Member> getByStatus(String aStatus) {
        return mapStatus.get(aStatus);
    }
    
    public Collection<Member> getChild(String aChild) {
        return child;
        
    }
    
    public Collection<Member> getChildren() {
        
        return child;
    }
    
    public Collection<Member> getPartner() {
        
        return partner;
    }
    
    public Collection<Member> getSibling() {
        
        return sibling;
    }
    
    @Override
    public void saveChildren(Member aMember) {
        
        members.add(aMember);
        categories.add(aMember.getCatagories());
        byId.put(aMember.getId(), aMember);
        map.put(aMember.getCatagories().toString(), aMember);
    }
    
    public void saveSibling(Member aMember) {
        
        members.add(aMember);
        categories.add(aMember.getCatagories());
        byId.put(aMember.getId(), aMember);
        map.put(aMember.getCatagories().toString(), aMember);
    }
    
    public void savePartner(Member aMember) {
        
        members.add(aMember);
        categories.add(aMember.getCatagories());
        byId.put(aMember.getId(), aMember);
        map.put(aMember.getCatagories().toString(), aMember);
    }
    
    public void savePayment(Payment payment){
        payments.add(payment);
    }
    
    public Collection<Payment> getAllPayments(){
        return payments;
    }

    @Override
    public Payment getByPaymentID(Integer pID) {
        return paymentID.get(pID);
    }

    @Override
    public Admin getAdmin(String aAdmin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
