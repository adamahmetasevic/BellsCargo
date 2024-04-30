package dmacc.beans;

//import javax.persistence.*;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
    private int accountId;
    private String accountType;
    private String accountName;
    private double accountBalance;
    private Date accountDate;
//    private int userId;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    // Constructors, getters, and setters
    public Account() {}

    public Account(int accountId, String accountType, String accountName, double accountBalance, Date accountDate, int userId) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        this.accountDate = accountDate;
//        this.userId = userId;
    }

    // Getters and Setters
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double tran, String trantype) {
        if(trantype.equals("deposit")) {
        	this.accountBalance += tran;
        } else {
        	this.accountBalance -= tran;
        }
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
