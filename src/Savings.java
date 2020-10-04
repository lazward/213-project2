/**
 *
 * 
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */

public class Savings extends Account {
    //For every SUBCLASS of an abstract class we need the abstract methods of the parent

    //We need three constants per account type
    private final double fee = 5 ;
    private final double waiver = 300 ;
    private final double interest = .0025 ;
    private final double specialInt = .0035;

    private final int months = 12;

    private boolean isLoyal ;

    public boolean getLoyal() {
        return isLoyal; 
    }

    public void setLoyal(boolean b) {
        isLoyal = b ;
    }

    public double monthlyInterest(){
        //monthly interest is annual/12 * current balance

        if(getLoyal() == true){

            return (specialInt/months) * getBalance();
        }else{
            return (interest/months) * getBalance();
        }

    }

    public double monthlyFee(){

        if(getBalance() >= waiver){
            return 0;
        }else{
            return fee;
        }
        
    }

    public String specialString() {

        if (isLoyal) {

            return "special Savings account" ;

        }

        return "" ;

    }

    
}
