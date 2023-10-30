package BankApp;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String iban;
    private String pin;
    private String fullName;
    private double balance;
    private List<Transaction> incomingTx;
    private List<Transaction> outgoingTx;
    private List<Transaction> viewTransactionTx;
    private String accountType;

    public BankAccount(String iban, String pin, String fullName,double balance, String accountType){
        this.iban = iban;
        this.pin = pin;
        this.fullName = fullName;
        this.balance = balance;
        this.incomingTx = new ArrayList<>();
        this.outgoingTx = new ArrayList<>();
        this.viewTransactionTx = new ArrayList<>();
        this.accountType = accountType;

    }
    public String getIban(){
        return iban;
    }
    public String getPin(){
        return pin;
    }
    public String getFullName(){
        return fullName;
    }
    public double getBalance(){
        return balance;
    }
    public List<Transaction> getIncomingTx(){
        return incomingTx;
    }
    public List<Transaction> getOutgoingTx(){
        return outgoingTx;
    }

    public List<Transaction> getViewTransactionTx(){
        return viewTransactionTx;
    }
    public String getAccountType(){
        return accountType;
    }

    public void deposit(double amount){
        balance += amount;
        incomingTx.add(new Transaction(amount));
    }
    public void withdraw(double amount){
        if (balance >= amount){
            balance -= amount;
            outgoingTx.add(new Transaction(amount));
        }else {
            System.out.println("Insufficient balance for the withdrawal.");
        }

    }

}

