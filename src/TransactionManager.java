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

                Profile profile = new Profile() ; // All of this hasn't been tested yet!
                profile.setFirstName(split[1]);
                profile.setLastName(split[2]) ;
                
                double bal = Double.parseDouble(split[3]) ;

                String[] d = split[4].split("/") ;

                Date date = new Date() ;
                date.setDate(d);

                    switch(input.charAt(1)) {

                        case 'C': // checking account
                            Checking checking = new Checking() ;
                            checking.setHolder(profile);
                            checking.setBalance(bal);
                            checking.setOpenDate(date);
                            checking.setDirectDeposit(Boolean.parseBoolean(split[5]));

                            System.out.println("first name: " + checking.getHolder().getFirstName() + " last name: " + checking.getHolder().getLastName()) ;
                            System.out.println("balance: " + checking.getBalance() ) ;
                            System.out.println("date: " + checking.getOpenDate().toString());
                            System.out.println("direct deposit: " + checking.getDirectDeposit());

                            database.add(checking) ;
                            break ;
                        case 'S': // savings account
                            Savings savings = new Savings() ;
                            savings.setHolder(profile) ;
                            savings.setBalance(bal) ;
                            savings.setOpenDate(date) ;
                            savings.setLoyal(Boolean.parseBoolean(split[5]));

                            database.add(savings) ;
                            break ;
                        case 'M': // money market account
                            MoneyMarket moneyMarket = new MoneyMarket() ;
                            moneyMarket.setHolder(profile) ;
                            moneyMarket.setBalance(bal) ;
                            moneyMarket.setOpenDate(date) ;
                            moneyMarket.setWithdrawals(0);

                            database.add(moneyMarket) ;    
                            break ;
                        default: // invalid
                            System.out.println("Command '" + split[0] + "' not supported!");
                            break ;

                    }

                    break ;

                case 'C': // close

                    profile = new Profile() ;
                    profile.setFirstName(split[1]);
                    profile.setLastName(split[2]) ;

                    switch(input.charAt(1)) {

                        case 'C': // checking account
                            Checking checking = new Checking() ;
                            checking.setHolder(profile);
                            if (database.remove(checking)) {

                                System.out.println("Account closed and removed from the database.");

                            } else {

                                System.out.println("Account does not exist.");

                            }
                            
                            break ;
                        case 'S': // savings account
                            Savings savings = new Savings() ;
                            savings.setHolder(profile);
                            if (database.remove(savings)) {

                                System.out.println("Account closed and removed from the database.");

                            } else {

                                System.out.println("Account does not exist.");

                            }
                            break ;
                        case 'M': // money market account
                        MoneyMarket moneyMarket = new MoneyMarket() ;
                        moneyMarket.setHolder(profile);
                        if (database.remove(moneyMarket)) {

                            System.out.println("Account closed and removed from the database.");

                        } else {

                            System.out.println("Account does not exist.");

                        }
                            break ;
                        default: // invalid
                            System.out.println("Command '" + split[0] + "' not supported!");
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
                    System.out.println("Command '" + split[0] +"' not supported!");
                    break ;

            }

        }
        
    }
    
}
