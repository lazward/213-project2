import java.util.Scanner ;

/**
 *
 * 
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */

public class TransactionManager {

    public void run() {

        System.out.println("Transaction processing starts.....");

        Scanner scanner = new Scanner(System.in) ;

        AccountDatabase database = new AccountDatabase() ;

        while (true) {

            String input = scanner.nextLine() ;

            if (input.equals("Q")) {

                System.out.println("Transaction processing completed.");
                break ;

            }

            if (input.length() < 2) { // Invalid input

                
                continue ;

            }

            String[] split = input.split(" ") ;

            switch(input.charAt(0)) {

                case 'O': // open

                    switch(input.charAt(1)) {

                        case 'C': // checking account
                            break ;
                        case 'S': // savings account
                            break ;
                        case 'M': // money market account
                            break ;
                        default: // invalid
                            break ;

                    }

                    break ;

                case 'C': // close

                    switch(input.charAt(1)) {

                        case 'C': // checking account
                            break ;
                        case 'S': // savings account
                            break ;
                        case 'M': // money market account
                            break ;
                        default: // invalid
                            break ;

                    }

                    break ;

                case 'D': // deposit
                    
                    switch(input.charAt(1)) {

                        case 'C': // checking account
                            break ;
                        case 'S': // savings account
                            break ;
                        case 'M': // money market account
                            break ;
                        default: // invalid
                            break ;

                    }

                    break ;

                case 'W': // withdraw
                    
                    switch(input.charAt(1)) {

                        case 'C': // checking account
                            break ;
                        case 'S': // savings account
                            break ;
                        case 'M': // money market account
                            break ;
                        default: // invalid
                            break ;


                    }

                    break ;

                case 'P':

                    switch(input.charAt(1)) {

                        case 'A': // print the list of accounts in the database
                            break ;
                        case 'D': // calculate the monthly interests and fees
                            break ;
                        case 'N': // same with PD but sort by the last names in ascending order
                            break ;
                        default:
                            break ;

                    }

                    break ;

                default:
                    break ;

            }

        }
        
    }
    
}
