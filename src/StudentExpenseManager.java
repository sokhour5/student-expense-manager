import java.util.ArrayList;
import java.util.Scanner;

// Main class
public class StudentExpenseManager {

    // List to store all expense objects.
    private ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        StudentExpenseManager project = new StudentExpenseManager();
        project.myProgram();
    }

    // Runs the main menu loop for the application.
    private void myProgram() {
        Scanner scanner = new Scanner(System.in);
        boolean terminate = false; // Controls when to terminate the program.

        // Main loop to keep showing the menu until the user terminates the program.
        while (!terminate) {
            printMenu(); // Display menu options.
            System.out.print("Enter your choice: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline.
            } else {
                // Handle invalid (non-numeric) input.
                System.out.println("Please enter a number between 1 and 6.");
                scanner.nextLine(); // Clear invalid input.
                continue; // repeat the menu.
            }

            // Process the user's menu choice.
            switch (choice) {
                case 1:
                    addExpense(scanner); // Option 1: Add normal expense.
                    break;
                case 2:
                    addDiscountedExpense(scanner); // Option 2: Add discounted expense.
                    break;
                case 3:
                    viewAllExpenses(); // Option 3: View all expenses.
                    break;
                case 4:
                    showTotalSpending(); // Option 4: Show total spending.
                    break;
                case 5:
                    showHighestExpense(); // Option 5: Show highest expense.
                    break;
                case 6:
                    // Option 6: Terminate the program.
                    System.out.println("Thank you for using Student Expense Manager. Program terminated.");
                    terminate = true;
                    break;
                default:
                    // Handle menu choices outside the valid range.
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }

            System.out.println();
        }

        scanner.close(); // Close the scanner.
    }

    // Prints the main menu.
    private void printMenu() {
        System.out.println("***********************************");
        System.out.println("===== Student Expense Manager =====");
        System.out.println("1. Add Expense");
        System.out.println("2. Add Discounted Expense");
        System.out.println("3. View All Expenses");
        System.out.println("4. Show Total Spending");
        System.out.println("5. Show Highest Expense");
        System.out.println("6. Terminate");
        System.out.println("***********************************");
    }

    // Adds a normal (non-discounted) expense to the list.
    private void addExpense(Scanner scanner) {
        System.out.print("Enter expense title: ");
        String title = scanner.nextLine(); // Read the expense title.

        System.out.print("Enter expense amount: ");
        double amount = readPositiveDouble(scanner);
        if (amount < 0) { // Validate that amount is non-negative.
            System.out.println("Amount cannot be negative. Expense not added.");
            return;
        }

        Expense expense = new Expense(title, amount);
        expenses.add(expense); // Store the expense in the list.
        System.out.println("Normal expense added.");
    }

    // Adds a discounted expense to the list.
    private void addDiscountedExpense(Scanner scanner) {
        System.out.print("Enter expense title: ");
        String title = scanner.nextLine(); // Read the expense title.

        System.out.print("Enter original amount: ");
        double amount = readPositiveDouble(scanner); // Read the original amount.
        if (amount < 0) { // Validate that amount is non-negative.
            System.out.println("Amount cannot be negative. Expense not added.");
            return;
        }

        System.out.print("Enter discount percentage (e.g. 10 for 10%): ");
        double discountPercent = readPositiveDouble(scanner); // Read the discount percent.
        if (discountPercent < 0) { // Validate that discount is non-negative.
            System.out.println("Discount percentage cannot be negative. Expense not added.");
            return;
        }

        DiscountedExpense expense = new DiscountedExpense(title, amount, discountPercent); // Create DiscountedExpense.
        expenses.add(expense); // Store the discounted expense in the list.
        System.out.println("Discounted expense added.");
    }

    // Displays all expenses
    private void viewAllExpenses() {
        if (expenses.isEmpty()) { // Check if there are any expenses.
            System.out.println("No expenses to display.");
            return;
        }

        System.out.println("All expenses:");
        for (Expense expense : expenses) {
            expense.showInfo(); // Print details of each expense.
        }
    }

    // Calculates and shows the total spending using final amounts.
    private void showTotalSpending() {
        if (expenses.isEmpty()) { // Check if there are any expenses.
            System.out.println("No expenses recorded yet.");
            return;
        }

        double total = 0.0;
        for (Expense expense : expenses) {
            total += expense.getFinalAmount(); // Add each final amount to total.
        }

        System.out.printf("Total spending (after discounts): £%.2f%n", total);
    }

    // Finds and shows the expense with the highest final amount.
    private void showHighestExpense() {
        if (expenses.isEmpty()) { // Check if there are any expenses.
            System.out.println("No expenses recorded yet.");
            return;
        }

        Expense highest = expenses.get(0); // assuming the first expense is highest.
        for (Expense expense : expenses) {
            if (expense.getFinalAmount() > highest.getFinalAmount()) { // Compare final amounts.
                highest = expense; // Update highest if a larger one is found.
            }
        }

        System.out.println("Highest expense:");
        highest.showInfo();
    }

    // Helper method to safely read a double value from the user.
    private double readPositiveDouble(Scanner scanner) {
        if (scanner.hasNextDouble()) { // Check that the next token is a double.
            double value = scanner.nextDouble();
            scanner.nextLine();
            return value; // Return the entered value.
        } else {
            System.out.println("Invalid number entered."); // Inform the user of invalid input.
            scanner.nextLine();
            return -1;
        }
    }
}