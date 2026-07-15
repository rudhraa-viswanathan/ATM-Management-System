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
            showMenu(account);
        } else {

            System.out.println("\nInvalid Account Number or PIN.");

        }
    }

    public void showMenu(Account account) {
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

        switch (choice) {

            case 1:
                balanceEnquiry(account);
                break;
            case 2:
                deposit(account);
                break;

            default:
                System.out.println("Feature coming soon...");

        }
    }

    public void balanceEnquiry(Account account) {

        System.out.println("\n==================================");
        System.out.println("      BALANCE ENQUIRY");
        System.out.println("==================================");
        System.out.println("Account Holder : " + account.getAccountHolderName());
        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println("Available Balance : ₹" + account.getBalance());

    }

    public void deposit(Account account) {
        System.out.println("\n==================================");
        System.out.println("           CASH DEPOSIT");
        System.out.println("==================================");

        System.out.print("Enter Deposit Amount: ₹");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        double currentBalance = account.getBalance();
        currentBalance += amount;
        account.setBalance(currentBalance);
        System.out.println("\n₹" + amount + " deposited successfully!");
        System.out.println("Updated Balance : ₹" + account.getBalance());
    }
}
