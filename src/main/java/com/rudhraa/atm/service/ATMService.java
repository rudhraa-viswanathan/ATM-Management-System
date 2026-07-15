package com.rudhraa.atm.service;
import com.rudhraa.atm.model.Account;
import java.util.Scanner;
public class ATMService {

    private final Scanner scanner = new Scanner(System.in);
    public void start() {

        Account account = new Account("1234567890","Rudhraa",1234,50000);


        System.out.print("Enter Account Number: ");
        String enteredAccountNumber = scanner.nextLine();

        System.out.print("Enter PIN: ");
        int enteredPin = scanner.nextInt();

        if (account.getAccountNumber().equals(enteredAccountNumber)
                && account.getPin() == enteredPin) {

            System.out.println("\nLogin Successful!");
            System.out.println("Welcome " + account.getAccountHolderName());
            showMenu();
        } else {

            System.out.println("\nInvalid Account Number or PIN.");

        }
    }

    public void showMenu() {
        System.out.println("\n==================================");
        System.out.println("            ATM MENU");
        System.out.println("==================================");
        System.out.println("1. Balance Enquiry");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Change PIN");
        System.out.println("5. Exit");

        System.out.print("\nEnter your choice: ");
        int choice = scanner.nextInt();

        System.out.println("You selected: " + choice);
    }
}
