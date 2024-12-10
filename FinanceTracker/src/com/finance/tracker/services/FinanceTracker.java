package com.finance.tracker.services;

import com.finance.tracker.models.Transaction;
import java.util.ArrayList;
import java.util.List;

public class FinanceTracker {
    private List<Transaction> transactions;

    public FinanceTracker() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double calculateTotalIncome() {
        return transactions.stream()
                          .filter(t -> t.getType().equals("income"))
                          .mapToDouble(Transaction::getAmount)
                          .sum();
    }

    public double calculateTotalExpenses() {
        return transactions.stream()
                          .filter(t -> t.getType().equals("expense"))
                          .mapToDouble(Transaction::getAmount)
                          .sum();
    }
}