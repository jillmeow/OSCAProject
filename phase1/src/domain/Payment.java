/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;
import net.sf.oval.constraint.DateRange;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * 
 * Web-based system for Otago Southland Chinese Association (OSCA)
 * 
 * @author Jill Mirandilla, Kendall Chin, Gary Lee, Sean Braid and Hans To'o
 */
public class Payment implements Comparable<Payment> {
    private Integer paymentID;
    private Integer memberID;
    
    @NotBlank(message="Amount must be provided")
    @NotEmpty(message="Amount must be provided")
    @NotNull(message = "Amount must be provided")
    private double amount;
    private String description;
    @NotEmpty(message = "Date Payed must be provided")
    private String date_payed;
    @NotEmpty(message = "Date Recorded must be provided")
    private String date_recorded;

    public Payment() {
    }

    public Payment(Integer paymentID, Integer memberID, double amount, String description, String date_payed, String date_recorded) {
        this.paymentID = paymentID;
        this.memberID = memberID;
        this.amount = amount;
        this.description = description;
        this.date_payed = date_payed;
        this.date_recorded = date_recorded;
    }

    @Override
    public String toString() {
        return "Payment ID: " + paymentID + " |Member ID: " + memberID + " |Amount: " + amount + " |Description: " + description + " |Date Payed: " + date_payed + " |Date Recorded: " + date_recorded +" |";
    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_payed() {
        return date_payed;
    }

    public void setDate_payed(String date_payed) {
        this.date_payed = date_payed;
    }

    public String getDate_recorded() {
        return date_recorded;
    }

    public void setDate_recorded(String date_recorded) {
        this.date_recorded = date_recorded;
    }
    
    @Override
    public int compareTo(Payment p){
        Integer pId = this.getPaymentID();
        Integer oId = p.getPaymentID();
        
        return pId.compareTo(oId);
    }
    
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.paymentID);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        
        final Payment other = (Payment) obj;
        if(!Objects.equals(this.paymentID, other.paymentID)){
            return false;
        }
        return true;
    }
    
    
}