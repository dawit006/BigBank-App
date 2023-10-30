package BankApp;

import java.time.LocalDateTime;

public class Transaction {
    private double amount;
    private LocalDateTime timestamp;
    public Transaction(double amount){
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }
    public double getAmount(){
        return amount;
    }
    public LocalDateTime getTimestamp(){
        return timestamp;
    }
}