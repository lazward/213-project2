/**
 *
 * 
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */

public class AccountDatabase {
    
    private Account[] accounts ;
    private int size ;

    private int find(Account account) {
        //Search through dataase and return respective index of account
        for(int i =0; i < accounts.length - 1; i++){

            if(accounts[i].toString().equals(account.toString())){
                //compare resulting toStrings
                return i;

            }
        }

        return -1 ;

    }

    private void grow() {


        final int increment = 5;
        
        
        Account[] newAccounts = new Account[accounts.length + increment] ; // Ask if this a magic number

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
        
        for(int i = size; i < accounts.length; i++){
            if(accounts[i] == null){
                accounts[i] = account;
                break ;
            }
        }
        
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

    }

    private void sortByLastName() {

    }

    public void printByDateOpen() {


    }

    public void printByLastName() {

    }

    public void printAccounts() {
        for(int i = 0; i < size; i ++){
            if(accounts[i] == null){
                continue;
            }
            System.out.println(accounts[i].toString());
        }
        

    }

}