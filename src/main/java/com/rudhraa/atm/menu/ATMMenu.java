package com.rudhraa.atm.menu;

import com.rudhraa.atm.model.Account;
import com.rudhraa.atm.service.AccountService;
import com.rudhraa.atm.service.TransactionService;

import java.util.Scanner;
import com.rudhraa.atm.util.ConsolePrinter;

public class ATMMenu {

    private final Scanner scanner = new Scanner(System.in);

    private final AccountService accountService;
    private final TransactionService transactionService;

    public ATMMenu(AccountService accountService,
                   TransactionService transactionService) {

        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    public void showMenu(Account account) {

        boolean running = true;

        while (running) {

            ConsolePrinter.printHeader("ATM MENU");
            System.out.println("1. Balance Enquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

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
                    System.out.println("Thank you for using our ATM.");
                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please select between 1 and 6."
                    );
            }
        }
    }
}