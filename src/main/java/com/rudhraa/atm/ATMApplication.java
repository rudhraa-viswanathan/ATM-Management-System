package com.rudhraa.atm;

import com.rudhraa.atm.model.Account;

public class ATMApplication {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("      ATM MANAGEMENT SYSTEM");
        System.out.println("==================================");
        System.out.println("Application Started...");



                Account account = new Account(
                        "1234567890",
                        "Rudhraa",
                        1234,
                        50000
                );

                System.out.println(account);
            }

}