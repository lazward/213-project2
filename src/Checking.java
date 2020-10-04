/**
 *
 * 
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */

public class Checking extends Account {

    private boolean directDeposit ;
    
    //We need three constants per account type
    private final double fee = 25 ;
    private final double waiver = 1500 ;
    private final double interest = .0005 ;
    private final int months = 12;

    public boolean getDirectDeposit() {
        return directDeposit ;
    }

    public void setDirectDeposit(boolean b) {
        directDeposit = b ;
    }

    public double monthlyInterest() {
      

        return ((interest/months) * getBalance());

    }

    public double monthlyFee() {
        if(getDirectDeposit() == true || getBalance() >= waiver){
            return 0;
        }else{
            return fee;
        }

    }

    public String specialString() {
          
        if(directDeposit){

            return "direct deposit account*";
        
        }

        return "" ;

}

}

    

