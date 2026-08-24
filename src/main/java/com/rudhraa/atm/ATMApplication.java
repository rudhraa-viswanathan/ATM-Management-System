package com.rudhraa.atm;
import com.rudhraa.atm.service.ATMService;

public class ATMApplication {

    public static void main(String[] args) {

        ATMService atmService = new ATMService();
        atmService.start();

            }

}