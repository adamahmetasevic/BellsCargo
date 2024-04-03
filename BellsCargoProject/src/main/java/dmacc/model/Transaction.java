package dmacc.model;
 
import javax.persistence.*;

import java.util.Date;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private String transactionType;
    private double transactionAmount;
    private Date transactionDate;
    private int accountId;
    
    
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Transaction() {}

    public Transaction(int transactionId, String transactionType, double transactionAmount, Date transactionDate, int accountId) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.accountId = accountId;
    }

    // Getters and Setters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
