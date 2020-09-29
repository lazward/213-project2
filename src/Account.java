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
        //Convert all respective objects to their string versions
        //Wll return *Name of holder* $000.000*Dateopened
        String res =  "*" +holder.getFirstName() + " " + holder.getLastName() + "* $" + Double.toString(balance)+ "*"+dateOpen.toString();

        return res;
        


    }

    public abstract double monthlyInterest() {

    }

    public abstract double monthlyFee() {
        
    }

    //Helper methods for accessing Private Variables

    public Profile getHolder(){
        return this.holder;
    }
    public double getBalance(){
        return this.balance;
    }
    public Date getOpenDate(){
        return this.dateOpen;

    }

}