/**
 *
 * 
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */

public abstract class Account {

    private Profile holder;
    private double balance;
    private Date dateOpen;

    /**
     * Debit the account's balance by a specified amount.
     * 
     * @param amount
     */
    public void debit(double amount) {

        balance = balance - amount;

    }

    /**
     * Credit the account's balance by a specified amount.
     * 
     * @param amount
     */
    public void credit(double amount) {

        balance = balance + amount;

    }

    @Override
    public String toString() {
        // Convert all respective objects to their string versions
        // Wll return *Name of holder* $000.000*Dateopened
        return "*" + this.getClass().getName() + "*" + holder.getFirstName() + " " + holder.getLastName() + "* $"
                + String.format("%.2f", balance) + "*" + dateOpen.toString() + "*" + specialString();

    }

    public abstract double monthlyInterest();

    public abstract double monthlyFee();

    // Helper methods for accessing Private Variables

    public Profile getHolder() {
        return this.holder;
    }

    public double getBalance() {
        return this.balance;
    }

    public Date getOpenDate() {
        return this.dateOpen;

    }

    // Helper setters
    public void setHolder(Profile profile) {
        this.holder = profile;
    }

    public void setBalance(double bal) {
        this.balance = bal;
    }

    public void setOpenDate(Date newDate) {
        this.dateOpen = newDate;
    }

    public abstract String specialString();

}