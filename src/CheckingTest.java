import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;

import org.junit.Test;

/**
 *
 * 
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */
public class CheckingTest {

    private static DecimalFormat df = new DecimalFormat("0.00") ;

    @Test
    public void testMonthlyInterest() {

        Checking checking = new Checking();
        checking.credit(1001.4);
        assertEquals("0.04", df.format(checking.monthlyInterest()));

        checking.debit(701.28); // current bal = 300.12
        assertEquals("0.01", df.format(checking.monthlyInterest()));

    }

    @Test
    public void testMonthlyFee() {

        Checking checking = new Checking();
        checking.credit(1000);
        assertEquals(25, checking.monthlyFee());

        checking.credit(500);
        assertEquals(0, checking.monthlyFee()); // Balance >= 1500 gets their fee waived

        checking.debit(1);
        assertEquals(25, checking.monthlyFee());

        checking.setDirectDeposit(true); // Fee is waived for direct deposit accounts
        assertEquals(0, checking.monthlyFee());

    }

}