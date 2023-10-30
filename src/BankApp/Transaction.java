package BankApp;

public class Transaction {
    private double amount;
    private String type;
    private Date timestamp;

    // Constructor
    public Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
        this.timestamp = new Date(); // You might want to use a more specific date-time library.
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

