public class DiscountedExpense extends Expense {

    private double discountPercent;  // e.g. 10 means 10%

    // creates a discounted expense with title, original amount, and discount percentage.
    public DiscountedExpense(String title, double amount, double discountPercent) {
        super(title, amount);
        this.discountPercent = discountPercent;
    }

    // Returns the discount percentagethe expense.
    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    // Calculates and returns the final amount after applying the discount.
    @Override
    public double getFinalAmount() {
        double amount = getAmount();
        return amount * (1 - discountPercent / 100.0);
    }

    // Prints the full information for this discounted expense.
    @Override
    public void showInfo() {
        System.out.printf(
                "Title: %s | Original: £%.2f | Final: £%.2f | Type: Discounted (%.1f%%%n",
                getTitle(), getAmount(), getFinalAmount(), discountPercent
        );
    }
}