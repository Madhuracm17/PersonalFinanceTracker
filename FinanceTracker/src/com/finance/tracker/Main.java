package com.finance.tracker;

import com.finance.tracker.models.Transaction;
import com.finance.tracker.services.FinanceTracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FinanceTracker tracker = new FinanceTracker();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter command (add/view/exit): ");
            command = scanner.nextLine();

            if (command.equals("add")) {
                System.out.println("Enter type (income/expense): ");
                String type = scanner.nextLine();
                System.out.println("Enter amount: ");
                double amount = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter category: ");
                String category = scanner.nextLine();
                System.out.println("Enter description: ");
                String description = scanner.nextLine();

                // Create a new Transaction object
                Transaction transaction = new Transaction(type, amount, category, description);
                
                // Add the transaction to the FinanceTracker
                tracker.addTransaction(transaction);
                System.out.println("Transaction added!");

            } else if (command.equals("view")) {
                // View all transactions
                System.out.println("Transaction History:");
                for (Transaction t : tracker.getTransactions()) {
                    System.out.println(t.getType() + ": " + t.getAmount() + " (" + t.getCategory() + ") - " + t.getDescription());
                }

                // Display total income and expenses
                System.out.println("Total Income: " + tracker.calculateTotalIncome());
                System.out.println("Total Expenses: " + tracker.calculateTotalExpenses());

            } else if (command.equals("exit")) {
                // Exit the application
                System.out.println("Exiting the application. Goodbye!");
                break;

            } else {
                System.out.println("Invalid command! Please enter 'add', 'view', or 'exit'.");
            }
        }

        // Close the scanner to avoid resource leaks
        scanner.close();
    }
}