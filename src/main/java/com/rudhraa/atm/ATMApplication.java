package com.rudhraa.atm;
import com.rudhraa.atm.service.ATMService;

public class ATMApplication {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("      ATM MANAGEMENT SYSTEM");
        System.out.println("==================================");
        System.out.println("Application Started...");

        ATMService atmService = new ATMService();
        atmService.start();

            }

}