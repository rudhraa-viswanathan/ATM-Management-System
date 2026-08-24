package com.rudhraa.atm.service;

import com.rudhraa.atm.model.Transaction;
import com.rudhraa.atm.util.ConsolePrinter;
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
        ConsolePrinter.printHeader("TRANSACTION HISTORY");

        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}