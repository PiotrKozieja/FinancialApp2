package PiotrK.FinancialApp2;

import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.math.MathContext;
import java.math.RoundingMode;
import java.math.BigDecimal;

import java.math.BigDecimal;
import java.sql.SQLOutput;

import static org.assertj.core.api.Assertions.*;
public class DataPreparationTest {
    @Test
    void isMonthlyPercnetCalculatorCorrect(){
        Double AnnualPercent = 8.56;
        BigDecimal AnnualPercentUsefulForm = new BigDecimal(AnnualPercent/100+1)
                .setScale(2, BigDecimal.ROUND_HALF_UP);
        //ex. 8 ->1.08
        BigDecimal AnnualPercentFromMonthlyPercent = DataPreparation.MonthlyPercentCalculator(AnnualPercent)
                        .pow(12).setScale(2, BigDecimal.ROUND_HALF_UP);
        //raises to the 12th power and rounds the number to the second decimal place.
        ;
        assert(AnnualPercentUsefulForm.equals(AnnualPercentFromMonthlyPercent));
    }

    @Test
    void isNumberOfStocksCalculatorCorrect(){
        BigDecimal StockPrice = new BigDecimal(2600);
        BigDecimal CashAmount = new BigDecimal(10000);
        BigDecimal NumberOfStocks = DataPreparation.NumberOfStocksCalculator(StockPrice,CashAmount);
        assert(NumberOfStocks.equals(new BigDecimal(3)));
    }
    @Test
    void isSavingAccountCalculatorCorrect(){
        BigDecimal StockPrice = new BigDecimal(2600);
        BigDecimal CashAmount = new BigDecimal(10000);
        BigDecimal SavingAccount = DataPreparation.SavingAccountCalculator(StockPrice,CashAmount);
        assert(SavingAccount.equals(new BigDecimal(2200)));
    }
    @Test
    void isDividendCalculatorCorrect(){
        BigDecimal StockPrice = new BigDecimal(2654.50);
        BigDecimal NumberOfStocks = new BigDecimal(1);
        BigDecimal DividendRate= new BigDecimal(5);
        BigDecimal CalculatedDividend = DataPreparation.DividendCalculator(StockPrice,NumberOfStocks,DividendRate)
                                        .setScale(2, RoundingMode.HALF_UP);
        assert(CalculatedDividend.equals(new BigDecimal("132.73")));
    }
    @Test
    void isStockPriceCalculatorCorrect(){
        BigDecimal StockPrice = new BigDecimal(2000);
        BigDecimal MonthlyRate = new BigDecimal(1.006434);
        BigDecimal CalculatedStockPrice = DataPreparation.StockPriceCalculator(StockPrice,MonthlyRate);
        assert(CalculatedStockPrice.equals(new BigDecimal("2012.87")));
    }
    @Test
    void isNumberOfStocksAfterPurchasesCalculatorCorrect(){
        BigDecimal StockPrice = new BigDecimal(2000);
        BigDecimal SavingAccount = new BigDecimal(3000);
        BigDecimal NumberOfStocks = new BigDecimal(4);
        BigDecimal CalculatedNumberOfStocks = DataPreparation.NumberOfStocksAfterPurchasesCalculator(StockPrice,SavingAccount,NumberOfStocks);
        assert(CalculatedNumberOfStocks.equals(new BigDecimal("5")));
    }
    @Test
    void SavingAccountAfterPurchasesCalculatorCorrect(){
        BigDecimal StockPrice = new BigDecimal(2000);
        BigDecimal SavingAccount = new BigDecimal(6200);
        BigDecimal CalculatedSavingAccount = DataPreparation.SavingAccountAfterPurchasesCalculator(StockPrice,SavingAccount);
        assert(CalculatedSavingAccount.equals(new BigDecimal("200")));
    }


}
