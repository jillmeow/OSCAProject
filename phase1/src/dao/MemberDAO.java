/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.*;
import java.util.Collection;

/**
 *
 * @author Kendall Lauren Chin
 */
public interface MemberDAO {

    void save(Member aMember);

    void delete(Member aMember);
    void deleteChild();
    void deleteSibling();
    void deletePartner();
    void saveChildren(Member aMember);
    void saveSibling(Member aMember);
    void savePartner(Member aMember);
    void savePayment(Payment payment);
    
    

    Collection<Member> getAll();
    
    Collection<Member> getChildren();
    
    Collection<Member> getSibling();
    
    Collection<Member> getPartner();
    
    Collection<Member> getChild(String aChild);

    Collection<String> getCategories();
    
    Collection<String> getStatus();

    Member getById(Integer aId);

    Collection<Member> getByCategories(String aCategory);
    
    Collection<Member> getByStatus(String aStatus);
    
    Collection<Payment> getAllPayments();
    
    Payment getByPaymentID(Integer pID);
    
    Admin getAdmin(String aAdmin);

}
