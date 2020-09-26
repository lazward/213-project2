public class Date implements Comparable<Date> {

    private int year ; 
    private int month ;
    private int day ;

    public int compareTo(Date date) {

        if (this.year < date.year) {

            return -1 ;

        } else if (this.year > date.year) {

            return 1 ;

        }

        if (this.month < date.month) {

            return -1 ;

        } else if (this.month > date.month) {

            return 1 ;

        }

        if (this.day < date.day) {

            return -1 ;

        } else if (this.day < date.day) {

            return 1 ;

        }

        return 0 ;

    }

    public String toString() {

        

    }

    public boolean isValid() {

    }
    
}
