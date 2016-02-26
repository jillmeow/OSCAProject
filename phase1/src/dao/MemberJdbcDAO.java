/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.*;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * Web-based system for Otago Southland Chinese Association (OSCA)
 * 
 * @author Jill Mirandilla, Kendall Chin, Gary Lee, Sean Braid and Hans To'o
 */
public class MemberJdbcDAO implements MemberDAO {

    public void save(Member aMember) {
        String sql = "merge into members (id, firstName, lastName, address, phoneNumber, email, partnersName,"
                + "siblingsName, catagories, subscription, child , status, eligibility) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (
                // get connection to database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters
            stmt.setInt(1, aMember.getId());
            stmt.setString(2, aMember.getFirstName());
            stmt.setString(3, aMember.getLastName());
            stmt.setString(4, aMember.getAddress());
            stmt.setString(5, aMember.getPhoneNumber());
            stmt.setString(6, aMember.getEmail());
            stmt.setString(7, aMember.getPartnersName());
            stmt.setString(8, aMember.getSiblingsName());
            stmt.setString(9, aMember.getCatagories().toString());
            stmt.setString(10, aMember.getSubscription());
            stmt.setString(11, aMember.getChildrenName());
            stmt.setString(12, aMember.getStatus());
            stmt.setString(13, aMember.getEligibility());
            //stmt.setString(12, aMember.getChineseStatus());
            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public void delete(Member aMember) {
        String sql = "delete from members where id = (?)";

        try (
                // get connection to database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters
            stmt.setInt(1, aMember.getId());

            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public void deleteChild() {
        String sql = "truncate table children";

        try (
                // get connection to database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters

            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public void deleteSibling() {
        String sql = "truncate table sibling";

        try (
                // get connection to database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters

            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<Member> getAll() {
        String sql = "select * from members order by id";
        try (
                // get a connection to the database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
// execute the query
            ResultSet rs = stmt.executeQuery();
// Create a collection for holding the student we get from the query.
// We are using a List in order to preserve the order in which
// the data was returned from the query.
            TreeSet<Member> members;
            members = new TreeSet<>();
            // iterate through the query results
            while (rs.next()) {
// get the data out of the query
                Integer id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String partnersName = rs.getString("partnersName");
                String siblingsName = rs.getString("siblingsName");
                String catagories = rs.getString("catagories");
                String subscription = rs.getString("subscription");
                String status = rs.getString("status");
                String child = rs.getString("child");
                String eligible = rs.getString("eligibility");
// use the data to create a student object
                Member s = new Member(id, firstName, lastName, address, phoneNumber, 
                        email, partnersName, siblingsName, catagories, subscription, status, eligible);
// and put it in the collection
                s.setChildrenName(child);
                //System.out.println(child);
                if (!catagories.equals("[]")) {

                    //System.out.println(catagories.substring(1, catagories.length()-1));
                    String[] participation = catagories.substring(1, catagories.length() - 1).split(", ");
                    for (String pt : participation) {
                        s.setCatagories(pt);
                    }
                }
                members.add(s);
            }
            return members;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<String> getCategories() {
        String sql = "select catagories from members order by catagories";
        try (
                // get a connection to the database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
// execute the query
            ResultSet rs = stmt.executeQuery();
// Create a collection for holding the student we get from the query.
// We are using a List in order to preserve the order in which
// the data was returned from the query.
            Set catagories = new HashSet();
            // iterate through the query results
            while (rs.next()) {
// get the data out of the query

                String category = rs.getString("catagories");
// use the data to create a student object

// and put it in the collection
                catagories.add(category);
            }
            return catagories;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<String> getStatus() {
        String sql = "select status from members order by status";
        try (
                // get a connection to the database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
// execute the query
            ResultSet rs = stmt.executeQuery();
// Create a collection for holding the student we get from the query.
// We are using a List in order to preserve the order in which
// the data was returned from the query.
            Set catagories = new HashSet();
            // iterate through the query results
            while (rs.next()) {
// get the data out of the query

                String status = rs.getString("status");
// use the data to create a student object

// and put it in the collection
                catagories.add(status);
            }
            return catagories;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Member getById(Integer aId) {
        String sql = "select * from members where id = (?);";
        try (
                // get a connection to the database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            stmt.setInt(1, aId);

// execute the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the query results
            while (rs.next()) {
// get the data out of the query
                Integer id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String partnersName = rs.getString("partnersName");
                String siblingsName = rs.getString("siblingsName");
                String catagories = rs.getString("catagories");
                String subscription = rs.getString("subscription");
                String status = rs.getString("status");
                String children = rs.getString("child");
                String eligible = rs.getString("eligibility");
// use the data to create a student object

                Member s = new Member(id, firstName, lastName, address, phoneNumber, email, 
                        partnersName, siblingsName, catagories, subscription, status, eligible);
                //System.out.println(s.getCatagories());
                s.setChildrenName(children);
                if (!catagories.equals("[]")) {
                    //System.out.println(catagories.substring(1, catagories.length()-1));
                    String[] participation = catagories.substring(1, catagories.length() - 1).split(", ");
                    for (String pt : participation) {
                        s.setCatagories(pt);
                    }
                }
                return s;
            }
            return null;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<Member> getByCategories(String aCategory) {
        String sql = "select * from members where catagories = '" + aCategory + "' order by id;";
        try (
                // get a connection to the database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
// execute the query
            ResultSet rs = stmt.executeQuery();

            Set products = new HashSet();
            // iterate through the query results
            while (rs.next()) {
// get the data out of the query
                Integer id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String partnersName = rs.getString("partnersName");
                String siblingsName = rs.getString("siblingsName");
                String catagories = rs.getString("catagories");
                String subscription = rs.getString("subscription");
                String status = rs.getString("status");
                String children = rs.getString("child");
                String eligible = rs.getString("eligibility");
// use the data to create a student object
                Member s = new Member(id, firstName, lastName, address, phoneNumber, 
                        email, partnersName, siblingsName, catagories, subscription, status, eligible);
// and put it in the collection
                s.setChildrenName(children);
                if (!catagories.equals("[]")) {

                    //System.out.println(catagories.substring(1, catagories.length()-1));
                    String[] participation = catagories.substring(1, catagories.length() - 1).split(", ");
                    for (String pt : participation) {
                        s.setCatagories(pt);
                    }
                }
                products.add(s);
            }
            return products;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    /**
     *
     * @param aChild
     * @return
     */
    @Override
    public Collection<Member> getChild(String aChild) {
        String sql = "select * from members where child = '" + aChild + "' order by id;";
        try (
                // get a connection to the database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
// execute the query
            ResultSet rs = stmt.executeQuery();

            Set products = new HashSet();
            // iterate through the query results
            while (rs.next()) {
// get the data out of the query
                Integer id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String partnersName = rs.getString("partnersName");
                String siblingsName = rs.getString("siblingsName");
                String catagories = rs.getString("catagories");
                String subscription = rs.getString("subscription");
                String status = rs.getString("status");
                String eligible = rs.getString("eligibility");
                System.out.println(catagories);
// use the data to create a student object
                Member s = new Member(id, firstName, lastName, address, phoneNumber, 
                        email, partnersName, siblingsName, catagories, subscription, status, eligible);
                                if (!catagories.equals("[]")) {

                    //System.out.println(catagories.substring(1, catagories.length()-1));
                    String[] participation = catagories.substring(1, catagories.length() - 1).split(", ");
                    for (String pt : participation) {
                        s.setCatagories(pt);
                    }
                }
// and put it in the collection
                products.add(s);
            }
            return products;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<Member> getChildren() {
        String sql = "select * from children;";
        try (
                // get a connection to the database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
// execute the query
            ResultSet rs = stmt.executeQuery();

            Set products = new HashSet();
            // iterate through the query results
            while (rs.next()) {
// get the data out of the query
                Integer id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");

                String catagories = rs.getString("catagories");
                String status = rs.getString("status");
                String eligible = rs.getString("eligibility");
                System.out.println(catagories);
// use the data to create a student object
                Member s = new Member(id, firstName, lastName, 
                        address, phoneNumber, email, catagories, status, eligible);
                                if (!catagories.equals("[]")) {

                    //System.out.println(catagories.substring(1, catagories.length()-1));
                    String[] participation = catagories.substring(1, catagories.length() - 1).split(", ");
                    for (String pt : participation) {
                        s.setCatagories(pt);
                    }
                }
// and put it in the collection
                products.add(s);
            }
            return products;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public Collection<Member> getSibling() {
        String sql = "select * from sibling;";
        try (
                // get a connection to the database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
// execute the query
            ResultSet rs = stmt.executeQuery();

            Set products = new HashSet();
            // iterate through the query results
            while (rs.next()) {
// get the data out of the query
                Integer id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String eligible = rs.getString("eligibility");
                String catagories = rs.getString("catagories");
                String status = rs.getString("status");
                System.out.println(catagories);
// use the data to create a student object
                Member s = new Member(id, firstName, lastName, 
                        address, phoneNumber, email, catagories, status, eligible);
                                if (!catagories.equals("[]")) {

                    //System.out.println(catagories.substring(1, catagories.length()-1));
                    String[] participation = catagories.substring(1, catagories.length() - 1).split(", ");
                    for (String pt : participation) {
                        s.setCatagories(pt);
                    }
                }
// and put it in the collection
                products.add(s);
            }
            return products;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public void saveChildren(Member aMember) {
        String sql = "merge into children (id, firstName, lastName, address, phoneNumber, email, "
                + " catagories, status, eligibility) values (?,?,?,?,?,?,?,?,?)";
        try (
                // get connection to database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters
            stmt.setInt(1, aMember.getId());
            stmt.setString(2, aMember.getFirstName());
            stmt.setString(3, aMember.getLastName());
            stmt.setString(4, aMember.getAddress());
            stmt.setString(5, aMember.getPhoneNumber());
            stmt.setString(6, aMember.getEmail());

            stmt.setString(7, aMember.getCatagories().toString());
            stmt.setString(8, aMember.getStatus());
            stmt.setString(9, aMember.getEligibility());
            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public void saveSibling(Member aMember) {
        String sql = "merge into sibling (id, firstName, lastName, address, phoneNumber, email, "
                + " catagories,  status, eligibility) values (?,?,?,?,?,?,?,?,?)";
        try (
                // get connection to database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters
            stmt.setInt(1, aMember.getId());
            stmt.setString(2, aMember.getFirstName());
            stmt.setString(3, aMember.getLastName());
            stmt.setString(4, aMember.getAddress());
            stmt.setString(5, aMember.getPhoneNumber());
            stmt.setString(6, aMember.getEmail());

            stmt.setString(7, aMember.getCatagories().toString());
            stmt.setString(8, aMember.getStatus());
            stmt.setString(9, aMember.getEligibility());
            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public void deletePartner() {
        String sql = "truncate table partner";

        try (
                // get connection to database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters

            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public void savePartner(Member aMember) {
        String sql = "merge into partner (id, firstName, lastName, address, phoneNumber, email, "
                + " catagories, status, eligibility ) values (?,?,?,?,?,?,?,?, ?)";
        try (
                // get connection to database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters
            stmt.setInt(1, aMember.getId());
            stmt.setString(2, aMember.getFirstName());
            stmt.setString(3, aMember.getLastName());
            stmt.setString(4, aMember.getAddress());
            stmt.setString(5, aMember.getPhoneNumber());
            stmt.setString(6, aMember.getEmail());

            stmt.setString(7, aMember.getCatagories().toString());
            stmt.setString(8, aMember.getStatus());
            stmt.setString(9, aMember.getEligibility());
            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<Member> getPartner() {
        String sql = "select * from partner;";
        try (
                // get a connection to the database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
// execute the query
            ResultSet rs = stmt.executeQuery();

            Set products = new HashSet();
            // iterate through the query results
            while (rs.next()) {
// get the data out of the query
                Integer id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");

                String catagories = rs.getString("catagories");
                String status = rs.getString("status");
                String eligible = rs.getString("eligibility");
                
// use the data to create a student object
                Member s = new Member(id, firstName, lastName, 
                        address, phoneNumber, email, catagories, status, eligible);
// and put it in the collection
                                if (!catagories.equals("[]")) {

                    //System.out.println(catagories.substring(1, catagories.length()-1));
                    String[] participation = catagories.substring(1, catagories.length() - 1).split(", ");
                    for (String pt : participation) {
                        s.setCatagories(pt);
                    }
                }
                products.add(s);
            }
            return products;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<Member> getByStatus(String aStatus) {

        String sql = "select * from members where status = '" + aStatus + "' order by id;";
        try (
                // get a connection to the database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
// execute the query
            ResultSet rs = stmt.executeQuery();

            Set members = new HashSet();
            // iterate through the query results
            while (rs.next()) {
// get the data out of the query
                Integer id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String partnersName = rs.getString("partnersName");
                String siblingsName = rs.getString("siblingsName");
                String catagories = rs.getString("catagories");
                String subscription = rs.getString("subscription");
                String status = rs.getString("status");
// use the data to create a student object
                String children = rs.getString("child");
                String eligible = rs.getString("eligibility");
                //String[] participation = catagories.substring(1, catagories.length() - 1).split(", ");
                //System.out.println();
                Member s = new Member(id, firstName, lastName, address, phoneNumber, email, 
                        partnersName, siblingsName, catagories, subscription, status, eligible);
// and put it in the collection
                s.setChildrenName(children);
                if (!catagories.equals("[]")) {

                    //System.out.println(catagories.substring(1, catagories.length()-1));
                    String[] participation = catagories.substring(1, catagories.length() - 1).split(", ");
                    for (String pt : participation) {
                        s.setCatagories(pt);
                    }
                }
                members.add(s);
            }
            return members;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }

    }

    public void savePayment(Payment payment) {
        String sql = "merge into payments (payment_id, id, amount, description, date_payed, date_recorded) values (?, ?, ?, ?, ?, ?)";
        try (
                // get connection to database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters
            System.out.println(payment);
            stmt.setInt(1, payment.getPaymentID());
            stmt.setInt(2, payment.getMemberID());
            stmt.setDouble(3, payment.getAmount());
            stmt.setString(4, payment.getDescription());
            stmt.setString(5, payment.getDate_payed());
            stmt.setString(6, payment.getDate_recorded());
            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Collection<Payment> getAllPayments() {
        String sql = "select * from payments order by payment_id";
        try (
                //get a connection to the database
                Connection dbCon = ShoppingConnection.getConnection();
                //create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // execute the query
            ResultSet rs = stmt.executeQuery();
            // Create a collection for holding the student we get from the query.
            // We are using a List in order to preserve the order in which
            // the data was returned from the query.
            TreeSet<Payment> payments;
            payments = new TreeSet<>();
            // iterate through the query results
            while (rs.next()) {
                // get the data out of the query
                Integer pID = rs.getInt("payment_id");
                Integer mID = rs.getInt("id");
                Double amount = rs.getDouble("amount");
                String description = rs.getString("description");
                String date_payed = rs.getString("date_payed");
                String date_recorded = rs.getString("date_recorded");
                Payment p = new Payment(pID, mID, amount, description, date_payed, date_recorded);
                payments.add(p);
            }
            return payments;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Payment getByPaymentID(Integer pID) {
        String sql = "select * from payments where payment_id = (?);";
        try (
                // get a connection to the database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {

                stmt.setInt(1, pID);

// execute the query
                ResultSet rs = stmt.executeQuery();

            // iterate through the query results
            while (rs.next()) {
// get the data out of the query
                Integer paymentID = rs.getInt("payment_id");
                Integer mID = rs.getInt("id");
                Double amount = rs.getDouble("amount");
                String description = rs.getString("description");
                String date_payed = rs.getString("date_payed");
                String date_recorded = rs.getString("date_recorded");
                Payment p = new Payment(paymentID, mID, amount, description, date_payed, date_recorded);
                return p;
            }
            return null;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
        public Admin getAdmin(String aAdmin) {
        Admin a = new Admin();
        String sql = "select * from admins where username = ?";
        try (
                //get a connection to the database
                Connection dbCon = ShoppingConnection.getConnection();
                //create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            
        System.out.println(aAdmin);
            stmt.setString(1, aAdmin);
            
                // execute the query
            ResultSet rs = stmt.executeQuery();
            
            
            
            while (rs.next()) {
                // get the data out of the query
                String aUser = rs.getString("username");
                String aPass = rs.getString("password");
                 a.setUsername(aUser);
                 a.setPassword(aPass);
                
            }
            
            
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
        return a;
}

}
