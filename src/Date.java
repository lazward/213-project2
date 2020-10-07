/**
 * A date class that is used in all accounts.
 * This class implements the Java Interface Comparable.
 * 
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */

public class Date implements Comparable<Date> {

    private int year;
    private int month;
    private int day;

    /**
     * 
     * Compare two dates, accounting for varying month lengths and leap years
     * 
     * @param date
     * @return
     */
    public int compareTo(Date date) {

        if (this.year < date.year) {

            return -1;

        } else if (this.year > date.year) {

            return 1;

        }

        if (this.month < date.month) {

            return -1;

        } else if (this.month > date.month) {

            return 1;

        }

        if (this.day < date.day) {

            return -1;

        } else if (this.day < date.day) {

            return 1;

        }

        return 0;

    }

    
    /**
     * 
     * An overridden toString method to return the proper formatted date.
     * 
     * @return String of any given Date.
     */
    @Override
    public String toString() {

        return Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);

    }

    /**
     * 
     * A helper method to check for invalid dates.
     * 
     * @return boolean, true if the date is valid, false if it isnt.
     */
    public boolean isValid() { // Check if these numbers count as magic numbers

        if (month < 1 || month > 12 || day < 1 || day > 31) {

            return false;

        }

        // Need to check for days of the month (30 vs 31 days, leap year, etc)

        if (month == 2) {

            if (day >= 30) {

                return false;

            }

            if (day == 29) {

                if (year % 4 != 0) { // Every year that is divisible by four is a leap year

                    return false;

                }

                if (year % 100 == 0 && year % 400 != 0) { // Years that are divisible by 100 are not leap years, but
                                                          // ones that are divisible by 400 are.

                    return false;

                }

            }

            return true;

        }

        if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) {

            return false;

        }

        return true;

    }

    /**
     * 
     * Take a split string array containing the month, date and year, and set the
     * date as such.
     * 
     * @param date
     */
    public void setDate(String[] date) {

        month = Integer.parseInt(date[0]);
        day = Integer.parseInt(date[1]);
        year = Integer.parseInt(date[2]);

    }

}
