package com.rudhraa.atm.service;

import com.rudhraa.atm.model.Account;
import java.util.Scanner;

public class AccountService {
    private final Scanner scanner = new Scanner(System.in);
    private final TransactionService transactionService;

    public AccountService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void balanceEnquiry(Account account) {
        System.out.println("\n==================================");
        transactionService.addTransaction("Balance Enquiry");
        System.out.println("==================================");
        System.out.println("BALANCE ENQUIRY");
        System.out.println("Account Holder : " + account.getAccountHolderName());
        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println("Available Balance : ₹" + account.getBalance());

    }

    public void deposit(Account account) {
        System.out.println("\n==================================");
        System.out.println("CASH DEPOSIT");
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
        transactionService.addTransaction("Deposited ₹" + amount);
        System.out.println("\n₹" + amount + " deposited successfully!");
        System.out.println("Updated Balance : ₹" + account.getBalance());
    }

    public void withdraw(Account account) {
        System.out.println("\n==================================");
        System.out.println("CASH WITHDRAW");
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
        transactionService.addTransaction("Withdrawn ₹" + amount);
        System.out.println("\n₹" + amount + " withdrawn successfully!");
        System.out.println("Remaining Balance : ₹" + account.getBalance());

    }

    public void changePin(Account account) {
        System.out.println("\n==================================");
        System.out.println("CHANGE PIN");
        System.out.println("==================================");
        System.out.print("Enter Current PIN: ");
        int currentPin = scanner.nextInt();

        if (currentPin != account.getPin()) {
            System.out.println("Incorrect current PIN.");
            return;
        }
        System.out.print("Enter New PIN: ");
        int newPin = scanner.nextInt();
        if (newPin < 1000 || newPin > 9999) {
            System.out.println("PIN must be exactly 4 digits.");
            return;
        }
        System.out.print("Confirm New PIN: ");
        int confirmPin = scanner.nextInt();
        if (newPin != confirmPin) {
            System.out.println("PIN confirmation does not match.");
            return;
        }
        account.setPin(newPin);
        transactionService.addTransaction("PIN Changed Successfully");
        System.out.println("\nPIN changed successfully.");

    }
}