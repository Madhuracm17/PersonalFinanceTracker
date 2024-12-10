package com.finance.tracker.models;

public class Transaction {
    private String type;       // "income" or "expense"
    private double amount;     // Amount of the transaction
    private String category;   // Category of the transaction
    private String description; // Description of the transaction

    // Constructor
    public Transaction(String type, double amount, String category, String description) {
        if (!type.equals("income") && !type.equals("expense")) {
            throw new IllegalArgumentException("Type must be 'income' or 'expense'");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    // Getters
    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    // Optional: Override toString() for better readability
    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
