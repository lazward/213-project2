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

            String[] split = input.split(" ") ;

            if (split[0].equals("Q")) {

                System.out.println("Transaction processing completed.");
                break ;

            }

            switch(input.charAt(0)) {

                case 'O':
                    switch(input.charAt(1)) {

                        case 'C':
                            break ;
                        case 'S':
                            break ;
                        case 'M':
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
