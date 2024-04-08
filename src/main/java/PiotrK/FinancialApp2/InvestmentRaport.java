package PiotrK.FinancialApp2;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class InvestmentRaport {
    public static void ShowMonthlySummary(int Month, int Year, BigDecimal NumberOfStocks, BigDecimal StockPrice, BigDecimal SavingAccount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        System.out.println(String.format("%02d.%02d", Month, Year) + "    " +
                "NOS: " + String.format("%04d", NumberOfStocks.intValue()) + "       StockP: " +
                decimalFormat.format(StockPrice) + "      SValue: " +
                decimalFormat.format(StockPrice.multiply(NumberOfStocks)) + "   SavingAcc: " +
                decimalFormat.format(SavingAccount));
    }
    public static void ShowInvestmentSummary(BigDecimal NumberOfStocks, BigDecimal StockPrice, BigDecimal SavingAccount, BigDecimal DividendAdd, BigDecimal CashAmount, int InvestmentDuration) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        System.out.println("\nAfter this time you've got " + NumberOfStocks + " stocks, they are worth " + decimalFormat.format(StockPrice.multiply(NumberOfStocks))
                + ", you also 've got " + decimalFormat.format(SavingAccount) + " ready to buy another stock");
        System.out.println("Your total profit is " + decimalFormat.format(
                StockPrice.multiply(NumberOfStocks)
                        .subtract(DividendAdd.multiply(new BigDecimal(12 * InvestmentDuration)))
                        .subtract(CashAmount)
                        .add(SavingAccount)));
        System.out.println("Your profit per month is " + decimalFormat.format(
                (StockPrice.multiply(NumberOfStocks)
                        .subtract(DividendAdd.multiply(new BigDecimal(12 * InvestmentDuration)))
                        .subtract(CashAmount)
                        .add(SavingAccount))
                        .divide(new BigDecimal(12 * InvestmentDuration), 2, BigDecimal.ROUND_HALF_DOWN)));
    }
    public static void DividendAddedMessage(BigDecimal NumberOfStocks,BigDecimal StockPrice, BigDecimal SavingAccount,BigDecimal DividendAdd,BigDecimal DividendRate){
        System.out.println("\nDividend per action: "+StockPrice.multiply(DividendRate.divide(new BigDecimal(100),2, BigDecimal.ROUND_HALF_UP))
                +" Counted by stock price: "+ StockPrice+", NumberOfStocks: "+NumberOfStocks);
        System.out.println("Dividend added:"+DividendAdd+"\n");
        System.out.println(SavingAccount);
    }
    public static void YearMessage(int Year){
        System.out.println("\n------------------------Year: "+Year+"-----------------------------------------------");
        System.out.println("\nLegend:\n\nDate: Number of stocks:    StockPrice:            StockValue:        Saving account:\n");
    }
}
