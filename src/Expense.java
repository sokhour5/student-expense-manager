public class Expense {

    private String title;
    private double amount;

    //creates a normal expense with a title and amount.
    public Expense(String title, double amount) {
        this.title = title;
        this.amount = amount;
    }

    // Returns the title of the expense.
    public String getTitle() {
        return title;
    }

    // Updates the title of the expense.
    public void setTitle(String title) {
        this.title = title;
    }

    // Returns the original amount of the expense.
    public double getAmount() {
        return amount;
    }

    // Updates the original amount of the expense.
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Returns the final amount (same as original for normal expenses).
    public double getFinalAmount() {
        return amount;
    }

    // Prints the basic information for this normal expense.
    public void showInfo() {
        System.out.printf("Title: %s | Original: £%.2f | Final: £%.2f | Type: Normal%n",
                title, amount, getFinalAmount());
    }
}