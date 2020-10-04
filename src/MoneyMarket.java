/**
 *
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

    public int getWithdrawals() {
        return withdrawals ;
    }

    public void setWithdrawals(int i) {
        withdrawals = i ;
    }

    public double monthlyInterest(){
        
        return (interest/months) * getBalance();

    }

    public double monthlyFee(){

        if(withdrawals <= 6 && getBalance() >= waiver){
            return 0;
        }else{
            return fee;
        }
        
    }

    public String specialString() { 

        if (withdrawals == 1) {

            return "1 withdrawal*" ;

        }

        return withdrawals + " withdrawals*";

    }

    
}
