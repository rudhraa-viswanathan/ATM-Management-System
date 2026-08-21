package com.rudhraa.atm.service;

import com.rudhraa.atm.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(String type) {

        transactions.add(new Transaction(type, 0));

    }

    public void addTransaction(String type, double amount) {

        transactions.add(new Transaction(type, amount));

    }

    public void showTransactionHistory() {

        System.out.println("\n==================================");
        System.out.println("      TRANSACTION HISTORY");
        System.out.println("==================================");

        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}