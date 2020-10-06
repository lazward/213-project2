import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/**
 *
 * 
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */

public class DateTest {
    
    @Test
    public void testIsValid() {

        Date date = new Date() ;
        date.setDate(new String[]{"01",  "01", "2020"});
        
        assertEquals(true, date.isValid());

        date.setDate(new String[]{"02", "29", "2020"}); // leap year
        assertEquals(true, date.isValid()) ;

        date.setDate(new String[]{"04", "31", "2020"}) ;
        assertEquals(false, date.isValid()) ;

        date.setDate(new String[]{"05", "32", "2020"}) ;
        assertEquals(false, date.isValid()) ;

        date.setDate(new String[]{"02", "29", "2000"});
        assertEquals(true, date.isValid()) ;

        date.setDate(new String[]{"02", "29", "3000"}) ;
        assertEquals(false, date.isValid()) ;

    }
    
}
