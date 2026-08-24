package com.rudhraa.atm.service;
import com.rudhraa.atm.menu.ATMMenu;
import com.rudhraa.atm.model.Account;


public class ATMService {

    private final TransactionService transactionService = new TransactionService();
    private final AccountService accountService = new AccountService(transactionService);
    private final AuthenticationService authenticationService = new AuthenticationService();
    private final ATMMenu atmMenu = new ATMMenu(accountService, transactionService);

    public void start() {

        Account account = new Account("1234567890","Rudhraa",1234,50000);


        boolean loginSuccessful = authenticationService.login(account);

        if (loginSuccessful) {

            transactionService.addTransaction("Login Successful");

            atmMenu.showMenu(account);
        }
    }
}
