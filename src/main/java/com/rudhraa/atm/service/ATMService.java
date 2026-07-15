package com.rudhraa.atm.service;
import com.rudhraa.atm.model.Account;
import java.util.Scanner;
public class ATMService {
    public void start() {

        Account account = new Account("1234567890","Rudhraa",1234,50000);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String enteredAccountNumber = scanner.nextLine();

        System.out.print("Enter PIN: ");
        int enteredPin = scanner.nextInt();

        if (account.getAccountNumber().equals(enteredAccountNumber)
                && account.getPin() == enteredPin) {

            System.out.println("\nLogin Successful!");
            System.out.println("Welcome " + account.getAccountHolderName());

        } else {

            System.out.println("\nInvalid Account Number or PIN.");

        }
    }
}
