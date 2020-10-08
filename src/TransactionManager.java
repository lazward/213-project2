import java.util.Scanner;

/**
 *
 * This is the user interface class that handles the transactions and displays
 * the results on the console.
 * 
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */

public class TransactionManager {

    /**
     * 
     * Driver method for taking in I/O from the user to process account methods
     * based on their input.
     * 
     */
    public void run() {

        System.out.println("Transaction processing starts.....");

        Scanner scanner = new Scanner(System.in);

        AccountDatabase database = new AccountDatabase();

        while (true) {

            String input = scanner.nextLine();

            if (input.equals("Q")) {

                System.out.println("Transaction processing completed.");
                break;

            }

            if (input.length() < 2) { // Invalid input

                System.out.println("Command '" + input + "' not supported!");
                continue;

            }

            String[] split = input.split(" ");

            switch (input.charAt(0)) {

                case 'O': { // open

                    Profile profile = new Profile();
                    profile.setFirstName(split[1]);
                    profile.setLastName(split[2]);

                    double bal;

                    try {

                        bal = Double.parseDouble(split[3]);

                    } catch (NumberFormatException nfe) {

                        System.out.println("Input data type mismatch.");
                        break;

                    }

                    String[] d = split[4].split("/");

                    Date date = new Date();

                    date.setDate(d);

                    if (!date.isValid()) {

                        System.out.println(date.toString() + " is not a valid date!");
                        break;

                    }

                    switch (input.charAt(1)) {

                        case 'C': // checking account
                            Checking checking = new Checking();
                            checking.setHolder(profile);
                            checking.setBalance(bal);
                            checking.setOpenDate(date);
                            if (!verifyBool(split[5])) {
                                System.out.println("Input data type mismatch.");
                                break;
                            }
                            checking.setDirectDeposit(Boolean.parseBoolean(split[5]));

                            if (!database.add(checking)) {

                                System.out.println("Account is already in the database.");
                                break;

                            }
                            System.out.println("Account opened and added to the database.");
                            break;
                        case 'S': // savings account
                            Savings savings = new Savings();
                            savings.setHolder(profile);
                            savings.setBalance(bal);
                            savings.setOpenDate(date);
                            if (!verifyBool(split[5])) {
                                System.out.println("Input data type mismatch.");
                                break;
                            }
                            savings.setLoyal(Boolean.parseBoolean(split[5]));

                            if (!database.add(savings)) {

                                System.out.println("Account is already in the database.");
                                break;

                            }
                            System.out.println("Account opened and added to the database.");
                            break;
                        case 'M': // money market account
                            MoneyMarket moneyMarket = new MoneyMarket();
                            moneyMarket.setHolder(profile);
                            moneyMarket.setBalance(bal);
                            moneyMarket.setOpenDate(date);
                            moneyMarket.setWithdrawals(0);

                            if (!database.add(moneyMarket)) {

                                System.out.println("Account is already in the database.");
                                break;

                            }
                            System.out.println("Account opened and added to the database.");
                            break;
                        default: // invalid
                            System.out.println("Command '" + split[0] + "' not supported!");
                            break;

                    }

                    break;

                }

                case 'C': { // close

                    Profile profile = new Profile();
                    profile.setFirstName(split[1]);
                    profile.setLastName(split[2]);

                    switch (input.charAt(1)) {

                        case 'C': // checking account
                            Checking checking = new Checking();
                            checking.setHolder(profile);
                            if (database.remove(checking)) {

                                System.out.println("Account closed and removed from the database.");

                            } else {

                                System.out.println("Account does not exist.");

                            }

                            break;
                        case 'S': // savings account
                            Savings savings = new Savings();
                            savings.setHolder(profile);
                            if (database.remove(savings)) {

                                System.out.println("Account closed and removed from the database.");

                            } else {

                                System.out.println("Account does not exist.");

                            }
                            break;
                        case 'M': // money market account
                            MoneyMarket moneyMarket = new MoneyMarket();
                            moneyMarket.setHolder(profile);
                            if (database.remove(moneyMarket)) {

                                System.out.println("Account closed and removed from the database.");

                            } else {

                                System.out.println("Account does not exist.");

                            }
                            break;
                        default: // invalid
                            System.out.println("Command '" + split[0] + "' not supported!");
                            break;

                    }

                    break;

                }

                case 'D': { // deposit

                    Profile profile = new Profile();
                    profile.setFirstName(split[1]);
                    profile.setLastName(split[2]);

                    double deposit;

                    try {

                        deposit = Double.parseDouble(split[3]);

                    } catch (NumberFormatException nfe) {

                        System.out.println("Input data type mismatch.");
                        break;

                    }

                    switch (input.charAt(1)) {

                        case 'C': // checking account
                            Checking checking = new Checking();
                            checking.setHolder(profile);

                            if (database.deposit(checking, deposit)) {

                                System.out.println(String.format("%,.2f", deposit) + " deposited to account.");

                            } else {

                                System.out.println("Account does not exist.");

                            }
                            break;
                        case 'S': // savings account
                            Savings savings = new Savings();
                            savings.setHolder(profile);

                            if (database.deposit(savings, deposit)) {

                                System.out.println(String.format("%,.2f", deposit) + " deposited to account.");

                            } else {

                                System.out.println("Account does not exist.");

                            }
                            break;
                        case 'M': // money market account
                            MoneyMarket moneyMarket = new MoneyMarket();
                            moneyMarket.setHolder(profile);

                            if (database.deposit(moneyMarket, deposit)) {

                                System.out.println(String.format("%,.2f", deposit) + " deposited to account.");

                            } else {

                                System.out.println("Account does not exist.");

                            }
                            break;
                        default: // invalid
                            System.out.println("Command '" + split[0] + "' not supported!");
                            break;

                    }

                    break;

                }

                case 'W': // withdraw

                    Profile profile = new Profile();
                    profile.setFirstName(split[1]);
                    profile.setLastName(split[2]);

                    double withdrawal;

                    try {

                        withdrawal = Double.parseDouble(split[3]);

                    } catch (NumberFormatException nfe) {

                        System.out.println("Input data type mismatch.");
                        break;

                    }

                    switch (input.charAt(1)) {

                        case 'C': { // checking account
                            Checking checking = new Checking();
                            checking.setHolder(profile);

                            int result = database.withdrawal(checking, withdrawal);

                            if (result == 0) {

                                System.out.println(String.format("%,.2f", withdrawal) + " withdrawn account.");

                            } else if (result == 1) {

                                System.out.println("Insufficient funds.");

                            } else {

                                System.out.println("Account does not exist.");

                            }

                            break;
                        }
                        case 'S': { // savings account
                            Savings savings = new Savings();
                            savings.setHolder(profile);

                            int result = database.withdrawal(savings, withdrawal);

                            if (result == 0) {

                                System.out.println(String.format("%,.2f", withdrawal) + " withdrawn account.");

                            } else if (result == 1) {

                                System.out.println("Insufficient funds.");

                            } else {

                                System.out.println("Account does not exist.");

                            }

                            break;
                        }
                        case 'M': { // money market account

                            MoneyMarket moneyMarket = new MoneyMarket();
                            moneyMarket.setHolder(profile);

                            int result = database.withdrawal(moneyMarket, withdrawal);

                            if (result == 0) {

                                database.incrementWithdrawals(moneyMarket);
                                System.out.println(String.format("%,.2f", withdrawal) + " withdrawn from account.");

                            } else if (result == 1) {

                                System.out.println("Insufficient funds.");

                            } else {

                                System.out.println("Account does not exist.");

                            }
                            break;
                        }
                        default: // invalid
                            System.out.println("Command '" + split[0] + "' not supported!");
                            break;

                    }

                    break;

                case 'P':

                    switch (input.charAt(1)) {

                        case 'A': // print the list of accounts in the database
                            if (checkEmptyDatabase(database.getAccounts())) {
                                System.out.println("Database is empty.");
                            }
                            database.printAccounts();
                            break;
                        case 'D': { // calculate the monthly interests and fees
                            if (checkEmptyDatabase(database.getAccounts())) {
                                System.out.println("Database is empty.");
                            }
                            database.printByDateOpen();
                            break;
                        }
                        case 'N': { // same with PD but sort by the last names in ascending order
                            if (checkEmptyDatabase(database.getAccounts())) {
                                System.out.println("Database is empty.");
                            }
                            database.printByLastName();
                            break;
                        }
                        default:
                            System.out.println("Command '" + split[0] + "' not supported!");
                            break;

                    }

                    break;

                default:
                    System.out.println("Command '" + split[0] + "' not supported!");
                    break;

            }

        }

        scanner.close();

    }

    /**
     * 
     * Helper method for verification of boolean inputs from the user.
     * 
     * @param s String from the user's input.
     * @return boolean, true if the boolean is valid input, false otherwise.
     * 
     */
    private boolean verifyBool(String s) { // Helper method for verification of valid boolean inputs

        if (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("false")) {

            return true;

        }

        return false;
    }

    /**
     * 
     * Helper method to check if any given Account Database is empty or not.
     * 
     * @param a Account database to be checked.
     * @return boolean, true if the database is empty, false otherwise.
     * 
     */
    private boolean checkEmptyDatabase(Account[] a) {

        for (int i = 0; i < a.length; i++) {

            if (a[i] != null) {

                return false;

            }

        }

        return true;

    }

}
