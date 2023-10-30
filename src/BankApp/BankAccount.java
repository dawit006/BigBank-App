package BankApp;

    public class BankAccount {
        private String iban;
        private String accountNumber;
        private String fullName;
        private double balance;
        private String accountType;
        private List<Transaction> incomingTx;
        private List<Transaction> outgoingTx;

        // Constructor
        public BankAccount(String iban, String accountNumber, String fullName, double balance, String accountType) {
            this.iban = iban;
            this.accountNumber = accountNumber;
            this.fullName = fullName;
            this.balance = balance;
            this.accountType = accountType;
            this.incomingTx = new ArrayList<>();
            this.outgoingTx = new ArrayList<>();
        }

        // Getters and Setters

        public String getIban() {
            return iban;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getFullName() {
            return fullName;
        }

        public double getBalance() {
            return balance;
        }

        public String getAccountType() {
            return accountType;
        }

        public List<Transaction> getIncomingTx() {
            return incomingTx;
        }

        public List<Transaction> getOutgoingTx() {
            return outgoingTx;
        }

        // Methods to deposit, withdraw, etc.

        public void deposit(double amount) {
            balance += amount;
            // Create a new transaction record
            Transaction transaction = new Transaction(amount, "Deposit");
            incomingTx.add(transaction);
        }

        public void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                // Create a new transaction record
                Transaction transaction = new Transaction(amount, "Withdrawal");
                outgoingTx.add(transaction);
            } else {
                System.out.println("Insufficient balance for withdrawal.");
            }
        }
    }


