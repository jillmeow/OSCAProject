/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNegative;
import net.sf.oval.constraint.NotNull;

/**
 *
 * @author Kendall Lauren Chin
 */
public class Member implements Comparable<Member> {

    public ArrayList<String> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<String> children) {
        this.children = children;
    }
// @NotNull(message = "Quantity must be provided.")
    // @NotNegative(message = "Quantity must be a postive number.")
    // @NotEmpty(message = "Quantity must be provided")
    //  @NotBlank(message = "Category must be provided.")
    //  @Length(min = 3, max = 11, message = "ID must contain between 3 and 7\10 digits (inclusive).")

    @NotEmpty(message = "ID must be provided")
    @NotBlank(message = "ID must be provided.")
    @NotNegative(message = "ID must be a postive number.")
 //@Length(min = 3, max = 10, message = "ID must contain between 3 and 7\10 digits (inclusive).")
    private Integer id;

    @NotEmpty(message = "First Name must be provided")
    @NotBlank(message = "First Name must be provided.")
    @NotNull(message = "First Name must be provided.")
    private String firstName;
    @NotEmpty(message = "Last Name must be provided")
    @NotBlank(message = "Last Name must be provided.")
    @NotNull(message = "Last Name must be provided.")
    private String lastName;
    @NotEmpty(message = "Address must be provided")
    @NotBlank(message = "Address must be provided.")
    @NotNull(message = "Address must be provided.")
    private String address;

    //@NotNull(message = "Phone Number must be provided.")
    @Length(min = 7, max = 11, message = "Phone Number must contain between 7 and 10 digits (inclusive).")
    private String phoneNumber;

    //@NotEmpty(message = "Email must be provided")
    //@NotBlank(message = "Email must be provided.")
    //@NotNull(message = "Email Address must be provided.")
    private String email;

    private String partnersName;

    private String siblingsName;
    
    private String childrenName;

    private ArrayList<String> catagories = new ArrayList<String>();

    @NotNull(message = "Subscription must be provided.")
    @NotEmpty(message = "Subscription must be provided")
    @NotBlank(message = "Subscription must be provided.")
    private String subscription = "Family (Parents and children under 21) - $20";
    //private String chineseStatus;
    private ArrayList<String> child = new ArrayList<String>();

    private ArrayList<String> children = new ArrayList<String>();

    private ArrayList<String> sibling = new ArrayList<String>();
    
    private String eligibility = "Yes";

    private String status;

    public Member(Integer id, String firstName, String lastName, String address, String phoneNumber, String email,
            String partnersName, String siblingsName, String catagories, String subscription, String status, String eligibility) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.partnersName = partnersName;
        this.siblingsName = siblingsName;
        this.subscription = subscription;
        this.status = status;
        //this.chineseStatus = chineseStatus;
        this.eligibility = eligibility;

    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getChildrenName(){
        return this.childrenName;
    }
    
    public void setChildrenName(String cN){
        this.childrenName = cN;
    }
    
    public Member(Integer id, String firstName, String lastName, String address, String phoneNumber, String email,
            String catagories, String status, String e) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
        this.eligibility = e;
    }
    /*
     @Override
     public String toString() {
     return "Member{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", partnersName=" + partnersName + ", siblingsName=" + siblingsName + ", catagories=" + catagories + ", subscription=" + subscription + ", child=" + child + '}';
     }
     */

    @Override
    public String toString() {
        //return "Member{" + " " + id + " " + firstName + " " + lastName + " " + address + " " + phoneNumber + " " + email + " " + catagories + " " + subscription + " " + status + '}';
        return "ID: " + id + " |Name: " + firstName + " " + lastName + " |Address: " + address + " |Phone #: " + phoneNumber + " |Email: " + email + " |Participation: " + catagories + " |Subscription Type: " + subscription + " |Status: " + status + " |Eligibility: " + eligibility; 
    }

    
    //@Override
   // public String toString() {
   //     return id + " " + firstName + " " + lastName + " " + subscription + " " + status;
   // }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getChild() {
        return child;
    }

    public void setChild(String s) {
        child.add(s);
    }

    public String toChildString() {
        return "Member{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", partnersName=" + partnersName + ", siblingsName=" + siblingsName + ", catagories=" + catagories + ", subscription=" + subscription + ", child=" + child + '}';
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public ArrayList<String> getCatagories() {
        return catagories;
    }

    public void setCatagories(String c) {
        catagories.add(c);
        // this.catagories = catagories;
    }

    public Member() { //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPartnersName() {
        return partnersName;
    }

    public void setPartnersName(String partnersName) {
        this.partnersName = partnersName;
    }

    public String getSiblingsName() {
        return siblingsName;
    }

    public void setSiblingsName(String siblingsName) {
        this.siblingsName = siblingsName;
    }

    /*
     public String getChineseStatus(){
     return chineseStatus;
     }
    
     public void setChineseStatus(String chineseStatus){
     this.chineseStatus = chineseStatus;
     }
     */
    @Override
    public int compareTo(Member aProduct) {
        Integer cid = this.getId();
        Integer tid = aProduct.getId();
        return cid.compareTo(tid);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Member other = (Member) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
