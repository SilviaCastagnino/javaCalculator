package workByu;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;

/**
 * AdvancedCalculator: A console-based application that performs basic arithmetic 
 * and maintains a limited history log of previous calculations.
 */
public class AdvancedCalculator {

    // Configuration: Limit history to the last 10 entries to manage memory
    private static final int MAX_HISTORY = 10;
    private static List<String> history = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        printHeader();

        // Main application loop
        while (isRunning) {
            displayMenu();
            // Ensure the user picks a valid menu option between 0 and 6
            int choice = getValidInteger(scanner, 0, 6);

            switch (choice) {
                case 0 -> { // Exit case
                    isRunning = false;
                    System.out.println("\n[SYSTEM] Closing application... Goodbye!");
                }
                case 5 -> showHistory();   // Display previous calculations
                case 6 -> clearHistory(); // Wipe the history list
                default -> {
                    // Handles options 1 through 4 (Math operations)
                    processMathOperation(choice, scanner);
                }
            }
            
            // Visual separator for readability between operations
            if (isRunning) {
                System.out.println("\n---------------------------------------");
            }
        }
        scanner.close(); // Resource management: Close the scanner on exit
    }

    /**
     * Prints the stylish application header.
     */
    private static void printHeader() {
        System.out.println("=======================================");
        System.out.println("      ADVANCED CALCULATOR SYSTEM       ");
        System.out.println("          Built for Success            ");
        System.out.println("=======================================");
    }

    /**
     * Displays the available command options to the user.
     */
    private static void displayMenu() {
        System.out.println("\n[AVAILABLE OPERATIONS]");
        System.out.println("1) Addition (+)");
        System.out.println("2) Subtraction (-)");
        System.out.println("3) Multiplication (*)");
        System.out.println("4) Division (/)");
        System.out.println("5) View History Log");
        System.out.println("6) Clear History");
        System.out.println("0) Exit Program");
    }

    /**
     * Orchestrates the math logic: gathers numbers, calculates, and saves results.
     */
    private static void processMathOperation(int choice, Scanner scanner) {
        double n1 = getValidDouble(scanner, "Enter first number: ");
        double n2 = getValidDouble(scanner, "Enter second number: ");

        double result = 0;
        String operationSymbol = "";
        boolean valid = true;

        // Perform the operation based on the user's menu choice
        switch (choice) {
            case 1 -> { result = n1 + n2; operationSymbol = "+"; }
            case 2 -> { result = n1 - n2; operationSymbol = "-"; }
            case 3 -> { result = n1 * n2; operationSymbol = "*"; }
            case 4 -> {
                // Logical Check: Prevent Division by Zero errors
                if (n2 == 0) {
                    System.out.println("ERROR: Division by zero is undefined.");
                    valid = false;
                } else {
                    result = n1 / n2;
                    operationSymbol = "/";
                }
            }
        }

        // Only save and display if the calculation was successful
        if (valid) {
            String record = String.format("%.2f %s %.2f = %.2f", n1, operationSymbol, n2, result);
            System.out.println("RESULT >> " + record);
            addToHistory(record);
        }
    }

    /**
     * Adds a new result to the history list and enforces the size limit.
     */
    private static void addToHistory(String entry) {
        if (history.size() >= MAX_HISTORY) {
            history.remove(0); // FIFO (First In, First Out): Remove oldest record
        }
        history.add(entry);
    }

    /**
     * Prints all recorded calculations in the history list.
     */
    private static void showHistory() {
        System.out.println("\n--- CALCULATION HISTORY ---");
        if (history.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ") " + history.get(i));
            }
        }
    }

    /**
     * Removes all entries from the history list.
     */
    private static void clearHistory() {
        history.clear();
        System.out.println("History cleared successfully.");
    }

    /**
     * Robust input handling for integers. 
     * Retries until the user provides a number within the specified range.
     */
    private static int getValidInteger(Scanner sc, int min, int max) {
        while (true) {
            try {
                System.out.print("Selection (" + min + "-" + max + "): ");
                int val = sc.nextInt();
                if (val >= min && val <= max) return val;
                System.out.println("Warning: Choice out of range.");
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid menu number.");
                sc.next(); // Clear the scanner buffer to prevent infinite loops
            }
        }
    }

    /**
     * Robust input handling for doubles.
     * Catches formatting errors (like typing letters instead of numbers).
     */
    private static double getValidDouble(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid numeric format.");
                sc.next(); // Clear the scanner buffer
            }
        }
    }
}