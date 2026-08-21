package com.rudhraa.atm.service;
import com.rudhraa.atm.model.Account;
import java.util.Scanner;

public class ATMService {

    private final Scanner scanner = new Scanner(System.in);
    private final TransactionService transactionService = new TransactionService();
    private final AccountService accountService = new AccountService(transactionService);
    private final AuthenticationService authenticationService = new AuthenticationService();

    public void start() {

        Account account = new Account("1234567890","Rudhraa",1234,50000);


        boolean loginSuccessful = authenticationService.login(account);

        if (loginSuccessful) {

            transactionService.addTransaction("Login Successful");

            showMenu(account);
        }
    }

    public void showMenu(Account account) {
        boolean running = true;

        while (running) {
        displayMenu();

        System.out.print("\nEnter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                accountService.balanceEnquiry(account);
                break;
            case 2:
                accountService.deposit(account);
                break;
            case 3:
                accountService.withdraw(account);
                break;
            case 4:
                accountService.changePin(account);
                break;
            case 5:
                transactionService.showTransactionHistory();
                break;
            case 6:
                exitMessage();
                running = false;
                break;

            default:
                System.out.println("Invalid choice. Please select between 1 and 6.");
        }
        }
    }

    private void displayMenu() {

        System.out.println("\n==================================");
        System.out.println("            ATM MENU");
        System.out.println("==================================");
        System.out.println("1. Balance Enquiry");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Change PIN");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");

    }

//    private void printHeader(String title) {
//
//        System.out.println("\n==================================");
//        System.out.printf("%20s%n", title);
//        System.out.println("==================================");
//
//    }









    private void exitMessage() {
        System.out.println("\n==================================");
        System.out.println("Thank you for using the ATM.");
        System.out.println("Have a great day!");
        System.out.println("==================================");
    }
}
