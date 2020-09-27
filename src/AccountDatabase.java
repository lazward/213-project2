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

    }

    private void grow() {

        Account[] newAccounts = new Account[accounts.length + 5] ;

        for (int i = 0 ; i < size ; i++) {

            newAccounts[i] = accounts[i] ;

        }

        accounts = newAccounts ;

    }
    
    public boolean add(Account account) {

    }

    public boolean remove(Account account) {

    }

    public boolean deposit(Account account, double amount) {

    }

    public int withdrawal(Account account, double amount) {

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
        
    }

}