/**
 *
 * This class represents a 'Money Market' account type.
 * 
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */

public class MoneyMarket extends Account {

    private int withdrawals ;


    //We need three constants per account type
    private final double fee = 12 ;
    private final double waiver = 2500 ;
    private final double interest = .0065 ;
    private final int months = 12;


    /**
     * 
     * Helper method to return the number of withdrawals for any given MoneyMarket Account.
     * 
     * @return int of the number of withdrawals for any given Money Market account.
     * 
     */
    public int getWithdrawals() {
        return withdrawals ;
    }

    /**
     * 
     * Helper method to set the number of withdrawals for any given Money Market Account.
     * 
     * @param i The number we want to set as the number of withdrawals.
     * 
     */
    public void setWithdrawals(int i) {
        withdrawals = i ;
    }

    
    /**
     * 
     * Method to calculate the monthly interest of any account.
     * 
     * @return double of the calculated monthly interest.
     * 
     */
    public double monthlyInterest(){
        
        return (interest/months) * getBalance();

    }

    /**
     * 
     * Method to calculate the monthly fee of any account.
     * 
     * @return double of the calculated monthly fee.
     * 
     */
    public double monthlyFee(){

        if(withdrawals <= 6 && getBalance() >= waiver){
            return 0;
        }else{
            return fee;
        }
        
    }

    /**
     * 
     * Method to find the special resultant string of any account.
     * 
     * @return string of this specific account.
     * 
     */
    public String specialString() { 

        if (withdrawals == 1) {

            return "1 withdrawal*" ;

        }

        return withdrawals + " withdrawals*";

    }

    
}
