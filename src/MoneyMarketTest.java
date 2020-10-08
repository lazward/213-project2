import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;

import org.junit.Test;

/**
 *
 * Utalizing the power of JUnit, this class is for verifying the functionality
 * of our MoneyMarket Methods.
 * 
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */
public class MoneyMarketTest {

    private static DecimalFormat df = new DecimalFormat("0.00");

    @Test
    public void testMonthlyInterest() {

        MoneyMarket moneyMarket = new MoneyMarket();
        moneyMarket.credit(600.33);
        assertEquals("0.33", df.format(moneyMarket.monthlyInterest()));
        moneyMarket.debit(143.55); // balance = 456.78
        assertEquals("0.25", df.format(moneyMarket.monthlyInterest()));

    }

    @Test
    public void testMonthlyFee() {

        MoneyMarket moneyMarket = new MoneyMarket();
        moneyMarket.credit(600.33);
        assertEquals(12, moneyMarket.monthlyFee());
        moneyMarket.credit(2500); // Balance >= 2500 get their fee waived
        assertEquals(0, moneyMarket.monthlyFee());
        moneyMarket.setWithdrawals(7); // Fee cannot be waived if withdrawals > 6
        assertEquals(12, moneyMarket.monthlyFee());

    }

}
