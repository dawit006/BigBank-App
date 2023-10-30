package BankApp;

import java.util.List;
import java.util.Scanner;

public class Login {
    public static BankAccount performLogin(List<BankAccount> listOfAccounts) {
        Scanner input = new Scanner(System.in);
        BankAccount account = null;

        while (true){
            System.out.print("Enter your IBAN: ");
            String enteredIBAN = input.nextLine();

            for (BankAccount acc : listOfAccounts){
                if (acc.getIban().equals(enteredIBAN)){
                    account = acc;
                    break;
                }
            }

            if (account != null){
                int pinAttempts = 0;
                boolean correctPIN = false;

                while (pinAttempts < 3 && !correctPIN){
                    System.out.print("Enter PIN: ");
                    String enteredPIN = input.nextLine();

                    if (account.getPin().equals(enteredPIN)){
                        correctPIN = true;

                    } else {
                        pinAttempts++;
                        System.out.println("Incorrect PIN. Attempts left: " + (3 - pinAttempts));
                    }
                }
                if (correctPIN){
                    return account;
                }else {
                    System.out.println("Maximum PIN login attempts exceeded. Exiting");
                    System.exit(0);
                }
            } else {
                System.out.println("Incorrect IBAN. Please enter the correct IBAN.");
            }

        }

    }
}