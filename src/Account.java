/**
 *
 * 
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */

public abstract class Account {

    private Profile holder ;
    private double balance ;
    private Date dateOpen ;

    /**
     * Debit the account's balance by a specified amount.
     * 
     * @param amount
     */
    public void debit(double amount) {

        balance = balance - amount ;

    }

    /**
     * Credit the account's balance by a specified amount.
     * 
     * @param amount
     */
    public void credit(double amount) {

        balance = balance + amount ;

    }

    public String toString() {

    }

    public abstract double monthlyInterest() {

    }

    public abstract double monthlyFee() {
        
    }

}