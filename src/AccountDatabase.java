/**
 *
 * 
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */

public class AccountDatabase {
    
    private Account[] accounts ;
    private int size ;

    public AccountDatabase() {
        accounts = new Account[5] ;
        size = 0 ;
    }

    private int find(Account account) {
        //Search through dataase and return respective index of account
        for(int i =0; i < accounts.length - 1; i++){

            if (accounts[i] == null) {

                continue ;

            }

            if(account.getHolder().getFirstName().equals(accounts[i].getHolder().getFirstName())){
                if(account.getHolder().getLastName().equals(accounts[i].getHolder().getLastName())){
                    //three else if for type of account

                    String str = account.getClass().getName();    

                    //if they match the account type
                    if(str.equals(accounts[i].getClass().getName())){
                        return i;
                    
                }
            }
               

            }
        }

        return -1 ;

    }

    private void grow() {


        final int increment = 5;
        
        
        Account[] newAccounts = new Account[accounts.length + increment] ;

        for (int i = 0 ; i < size ; i++) {

            newAccounts[i] = accounts[i] ;

        }

        accounts = newAccounts ;

    }
    
    /**
     * 
     * @param account
     * @return
     */
    public boolean add(Account account) {
        //Check Capacity and grow if needed
        int index = find(account);
        //if Account already exists
        if(index != -1){
            return false;
        }
        
        if(size == accounts.length){
            grow();
        }
        
        for(int i = 0; i < accounts.length; i++){
            if(accounts[i] == null){
                accounts[i] = account;
                break ;
            }
        }

        size++ ;
        
        return true ;

    }

    /**
     * 
     * @param account
     * @return
     */
    public boolean remove(Account account) {

        int index = find(account) ;

        if (index == -1) { // Account doesn't exist

            return false ;

        }
        
        accounts[index] = null ; //will need to add nullcheck in the print

        size-- ;

        return true ;

    }

    /**
     * 
     * @param account
     * @param amount
     * @return
     */
    public boolean deposit(Account account, double amount) {
        // find + credit

        int index = find(account) ;

        if (index == -1) { // If account doeesn't exist

           return false ;

        }

        accounts[index].credit(amount) ;

        return true ;


    }

    /**
     * 
     * @param account
     * @param amount
     * @return
     */
    public int withdrawal(Account account, double amount) {
        //find + debit

        int index = find(account) ;

        if (index == -1) { // If account doesn't exist

            return -1 ;

        }

        if (accounts[index].getBalance() - amount <= 0) { // Insufficient funds

            return 1 ;

        }

        accounts[index].debit(amount) ; // Transaction successful

        return 0 ;


    }

    private void sortByDateOpen() {

        Account temp;
       
        for(int i = 0; i < size-1; i ++){
            if (accounts[i] == null) {

                continue ;

            }

            for(int j = i+1; j < size; j++){

                if (accounts[j] == null) {

                    continue ;

                }

                if( accounts[i].getOpenDate().compareTo(accounts[j].getOpenDate()) == 1){ //compares i to j
                   
                    temp= accounts[i];
                    accounts[i] = accounts[j];
                    accounts[j] = temp;
                }

            }
        }


    }

    private void sortByLastName() {

        Account temp;

        for(int i =0; i < size - 1; i ++){
            if (accounts[i] == null) {

                continue ;

            }

            for(int k = i +1; k < size; k++){
                if (accounts[k] == null) {

                    continue ;
    
                }
                if(accounts[i].getHolder().getLastName().compareToIgnoreCase(accounts[k].getHolder().getLastName()) > 0){
                    temp = accounts[i];
                    accounts[i] = accounts[k];
                    accounts[k] = temp;
                }
            }
        }
        
        

    }

    public void printByDateOpen() {
        
        sortByDateOpen();

        for(int i = 0; i < accounts.length; i ++){
            if (accounts[i] == null) {

                continue ;

            }

            System.out.println(accounts[i].toString()) ;
            double interest = accounts[i].monthlyInterest() ;
            System.out.println("-interest: $ " + String.format("%.2f", interest)) ;
            double fee = accounts[i].monthlyFee() ;
            System.out.println("-fee: $ " + String.format("%.2f", fee));
            accounts[i].setBalance(accounts[i].getBalance() + interest - fee) ;
            System.out.println("-new balance: $ " + String.format("%.2f", accounts[i].getBalance())) ;

        }



    }

    public void printByLastName() {

        sortByLastName();

        for(int i =0; i < accounts.length; i ++){
            if (accounts[i] == null) {

                continue ;

            }
            System.out.println(accounts[i].toString()) ;
            double interest = accounts[i].monthlyInterest() ;
            System.out.println("-interest: $ " + String.format("%.2f", interest)) ;
            double fee = accounts[i].monthlyFee() ;
            System.out.println("-fee: $ " + String.format("%.2f", fee));
            accounts[i].setBalance(accounts[i].getBalance() + interest - fee) ;
            System.out.println("-new balance: $ " + String.format("%.2f", accounts[i].getBalance())) ;
        }

    }

    public void printAccounts() {

        for(int i = 0; i < size; i ++){
            if(accounts[i] == null){
                continue;
            }
            System.out.println(accounts[i].toString());
        }
        

    }
    public int getSize(){
        return this.size;
    }

    public Account[] getAccounts(){
        return this.accounts;
    }

    public void incrementWithdrawals(MoneyMarket m) {

        int index = find(m) ;

        MoneyMarket temp = (MoneyMarket)accounts[index] ;
        temp.setWithdrawals(temp.getWithdrawals()+ 1);
        accounts[index] = temp ;

    }
    
}