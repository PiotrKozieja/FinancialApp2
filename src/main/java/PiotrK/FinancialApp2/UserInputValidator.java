package PiotrK.FinancialApp2;

import java.math.BigDecimal;

public class UserInputValidator {
    public static boolean CheckInput(BigDecimal StockPrice, int MonthOfDividend, BigDecimal DividendRate, BigDecimal CashAmount, BigDecimal AnnualRate, int InvestmentDuration, BigDecimal MonthlySavingAccountAdd) {
        try {

            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
