package com.rudhraa.atm.service;

import com.rudhraa.atm.model.Account;

import java.util.Scanner;

public class AuthenticationService {

    private final Scanner scanner = new Scanner(System.in);

    public boolean login(Account account) {

        System.out.print("Enter Account Number: ");
        String enteredAccountNumber = scanner.nextLine();

        System.out.print("Enter PIN: ");
        int enteredPin = scanner.nextInt();

        if (account.getAccountNumber().equals(enteredAccountNumber)
                && account.getPin() == enteredPin) {

            System.out.println("\nLogin Successful!");
            System.out.println("Welcome " + account.getAccountHolderName());

            return true;

        } else {

            System.out.println("\nInvalid Account Number or PIN.");

            return false;
        }
    }
}