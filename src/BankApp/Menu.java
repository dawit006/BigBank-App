package BankApp;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<BankAccount> listofAccounts = new ArrayList<>();

        listofAccounts.add(new BankAccount("BE50950028030000", "0001", "John Abraham", 1000.0, "Saving"));
        listofAccounts.add(new BankAccount("BE50950128030000", "0012", "Celina Mark", 1500.0, "Saving"));
        listofAccounts.add(new BankAccount("BE50950028030000", "0123", "Alexander Adam", 2000.0, "Saving"));

        System.out.println("Welcome to the BigBank Application");

        BankAccount account = Login.performLogin(listofAccounts);


        System.out.println("Welcome: " + account.getFullName() + "!");
        System.out.println("Account Type: " + account.getAccountType());
        System.out.println("Balance: $" + account.getBalance());
        Menu.showMainMenu(input, account, listofAccounts);

    }
    private static void showMainMenu(Scanner input, BankAccount account, List<BankAccount> listOfAccounts){
        while (true) {
            System.out.println("\nMain Menu");
            System.out.println("1: Check Balance");
            System.out.println("2: Deposit");
            System.out.println("3: Withdraw");
            System.out.println("4: View Transactions");
            System.out.println("5: Make Transfer");
            System.out.println("6: Sign Out");
            System.out.print("Enter your choice");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    checkBalance(account);
                    break;
                case 2:
                    deposit(input, account);
                    break;
                case 3:
                    withdraw(input, account);
                case 4:
                    viewtransaction(account);
                    break;
                case 5:
                    makeTransfer(input, account, listOfAccounts);
                    break;
                case 6:
                    System.out.println("Signing out. Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }

    }
    public static void checkBalance(BankAccount account){
        System.out.println("Account Balance: $" + account.getBalance());
    }
    public static void deposit(Scanner input, BankAccount account){
        System.out.println("Enter the deposit amount: $");
        double amount = input.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit of $" + amount + "successful");
    }
    public static void withdraw(Scanner input, BankAccount account){
        System.out.println("Enter the withdrawal amount: $");
        double amount = input.nextDouble();
        account.withdraw(amount);

    }
    public static void viewIncomingTransaction(BankAccount account) {
        System.out.println("Incoming Transaction");
        List<Transaction> incomingTx = account.getIncomingTx();
        for (Transaction tx : incomingTx) {
            System.out.println("Amount $" + tx.getAmount() + " | Timestamp: " + tx.getTimestamp());
        }

    }
    public static void viewOutgoingTransaction(BankAccount account){
        System.out.println("Outgoing Transaction:");
        List<Transaction> outgoingTx = account.getOutgoingTx();
        for (Transaction tx : outgoingTx) {
            System.out.println("Amount: $" + tx.getAmount() + " | Timestamp: " + tx.getTimestamp());
        }
    }
    public static void viewtransaction(BankAccount account){
        System.out.println("All Transactions:");
        List<Transaction> incomingTx = account.getIncomingTx();
        List<Transaction> outgoingTx = account.getOutgoingTx();

        System.out.println("Incoming Transaction");
        for (Transaction tx : incomingTx){
            System.out.println("Amount $" + tx.getAmount() + " | Timestamp: " + tx.getTimestamp());
        }
        System.out.println("Outgoing Transaction");
        for (Transaction tx : outgoingTx){
            System.out.println("Amount: $" + tx.getAmount() + " | Timestamp: " + tx.getTimestamp());
        }
    }
    private static void makeTransfer(Scanner input, BankAccount sender, List<BankAccount> listOfAccounts) {
        System.out.println("Enter the recipient's IBAN: ");
        String recipientIBAN = input.nextLine();

        BankAccount recipient = null;
        boolean isRecipientIBANValid = false;

        for (BankAccount acc : listOfAccounts) {
            if (acc.getIban().equals(recipientIBAN)) {
                recipient = acc;
                isRecipientIBANValid = true;
                break;
            }
        }

        if (!isRecipientIBANValid) {
            System.out.println("Recipient account not found. Please enter a valid IBAN.");
            return;
        }

        System.out.println("Enter the full name of the recipient: ");
        String recipientFullName = input.nextLine();

        if (!recipient.getFullName().equalsIgnoreCase(recipientFullName)) {
            System.out.println("Recipient full name does not match. Please enter the correct full name.");
            return;
        }

        System.out.print("Enter the amount to transfer: ");
        double amountToTransfer = input.nextDouble();
        input.nextLine();

        if (sender.getBalance() >= amountToTransfer) {
            sender.withdraw(amountToTransfer);
            recipient.deposit(amountToTransfer);
            System.out.println("Transfer successful. Thank you!");
        } else {
            System.out.println("Insufficient balance for the transfer.");
        }
    }

}

