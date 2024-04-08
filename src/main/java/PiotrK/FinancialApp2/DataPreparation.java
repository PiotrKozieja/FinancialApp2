package PiotrK.FinancialApp2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class DataPreparation {
    public static BigDecimal MonthlyPercentCalculator(double AnnualRate) {
        BigDecimal MonthlyPercent = new BigDecimal(Math.pow(1 + (AnnualRate / 100), 1.0 / 12));
        return MonthlyPercent;
    }
    public static BigDecimal NumberOfStocksCalculator(BigDecimal StockPrice,BigDecimal CashAmount){
        BigDecimal NumberOfStocks = CashAmount.divide(StockPrice,0, RoundingMode.FLOOR);
        return NumberOfStocks;
    }
    public static BigDecimal SavingAccountCalculator(BigDecimal StockPrice,BigDecimal CashAmount){
        BigDecimal SavingAccount = CashAmount.subtract(NumberOfStocksCalculator(StockPrice,CashAmount).multiply(StockPrice));
        return SavingAccount;
    }
    public static BigDecimal DividendCalculator(BigDecimal StockPrice, BigDecimal NumberOfStocks, BigDecimal DividendRate){
        BigDecimal CalculatedDividend = NumberOfStocks.multiply(StockPrice.multiply(DividendRate.divide(new BigDecimal(100),2, BigDecimal.ROUND_HALF_UP)))
                                        .setScale(2, RoundingMode.HALF_UP);
        return  CalculatedDividend;
    }
    public static BigDecimal StockPriceCalculator(BigDecimal StockPrice,BigDecimal MonthlyRate){
        BigDecimal CalculatedStockPrice = StockPrice.multiply(MonthlyRate).setScale(2, BigDecimal.ROUND_HALF_UP);
        return CalculatedStockPrice;
    }
    public static BigDecimal NumberOfStocksAfterPurchasesCalculator(BigDecimal StockPrice,BigDecimal SavingAccount,BigDecimal NumberOfStocks){
        BigDecimal CalculatedNumberOfStocks = NumberOfStocks.add(SavingAccount.divide(StockPrice,0,BigDecimal.ROUND_FLOOR));
        return CalculatedNumberOfStocks;
    }
    public static BigDecimal SavingAccountAfterPurchasesCalculator(BigDecimal StockPrice,BigDecimal SavingAccount){
        BigDecimal CalculatedSavingAccount = SavingAccount.subtract(SavingAccount.divide(StockPrice,0,BigDecimal.ROUND_FLOOR).multiply(StockPrice));
        return CalculatedSavingAccount;
    }

}
