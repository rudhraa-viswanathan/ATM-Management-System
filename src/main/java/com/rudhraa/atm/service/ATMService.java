package com.rudhraa.atm.service;
import com.rudhraa.atm.model.Account;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class ATMService {

    private final Scanner scanner = new Scanner(System.in);
    private final List<String> transactions = new ArrayList<>();

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
            transactions.add("Login Successful");
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
            case 3:
                withdraw(account);
                break;
            case 4:
                changePin(account);
                break;
            case 5:
                transactionHistory();
                break;
            case 6:
                System.out.println("Thank you for using our ATM.");
                break;

            default:
                System.out.println("Feature coming soon...");

        }
    }

    public void balanceEnquiry(Account account) {
        transactions.add("Balance Enquiry");
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
        transactions.add("Deposited ₹" + amount);
        System.out.println("\n₹" + amount + " deposited successfully!");
        System.out.println("Updated Balance : ₹" + account.getBalance());
    }

    public void withdraw(Account account) {
        System.out.println("\n==================================");
        System.out.println("        CASH WITHDRAWAL");
        System.out.println("==================================");
        System.out.print("Enter Withdrawal Amount: ₹");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance.");
            System.out.println("Available Balance : ₹" + account.getBalance());
            return;
        }
        double currentBalance = account.getBalance();

        currentBalance -= amount;

        account.setBalance(currentBalance);
        transactions.add("Withdrawn ₹" + amount);
        System.out.println("\n₹" + amount + " withdrawn successfully!");
        System.out.println("Remaining Balance : ₹" + account.getBalance());

    }

    public void changePin(Account account) {
        System.out.println("\n==================================");
        System.out.println("          CHANGE PIN");
        System.out.println("==================================");
        System.out.print("Enter Current PIN: ");
        int currentPin = scanner.nextInt();

        if (currentPin != account.getPin()) {
            System.out.println("Incorrect current PIN.");
            return;
        }
        System.out.print("Enter New PIN: ");
        int newPin = scanner.nextInt();
        System.out.print("Confirm New PIN: ");
        int confirmPin = scanner.nextInt();
        if (newPin != confirmPin) {
            System.out.println("PIN confirmation does not match.");
            return;
        }
        account.setPin(newPin);
        transactions.add("PIN Changed Successfully");
        System.out.println("\nPIN changed successfully.");

    }

    public void transactionHistory() {

        System.out.println("\n==================================");
        System.out.println("      TRANSACTION HISTORY");
        System.out.println("==================================");

        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
