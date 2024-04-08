package PiotrK.FinancialApp2;

import javax.xml.crypto.Data;
import java.math.BigDecimal;

public class Investment {
    public static void InvestmentCalculator(BigDecimal StockPrice,int MonthOfDividend,BigDecimal DividendRate,BigDecimal CashAmount,double AnnualRate,int InvestmentDuration,BigDecimal MonthlySavingAccountAdd){
        BigDecimal NumberOfStocks = DataPreparation.NumberOfStocksCalculator(StockPrice,CashAmount);
        BigDecimal SavingAccount = DataPreparation.SavingAccountCalculator(StockPrice,CashAmount);
        BigDecimal MonthlyRate = DataPreparation.MonthlyPercentCalculator(AnnualRate);
        for(int Year=1;Year<=InvestmentDuration;Year++){              ///years
            InvestmentRaport.YearMessage(Year);
            for(int Month=1;Month<=12;Month++){         ///months
                SavingAccount = SavingAccount.add(MonthlySavingAccountAdd);
                StockPrice = DataPreparation.StockPriceCalculator(StockPrice,MonthlyRate);
                if(Month == MonthOfDividend){
                    BigDecimal DividendAdd = DataPreparation.DividendCalculator(StockPrice,NumberOfStocks,DividendRate);
                    SavingAccount = SavingAccount.add(DividendAdd);
                    InvestmentRaport.DividendAddedMessage(NumberOfStocks,StockPrice,SavingAccount,DividendAdd,DividendRate);
                }
                //SavingAccount>=StockPrice
                if(SavingAccount.compareTo(StockPrice)>=0){
                    NumberOfStocks = DataPreparation.NumberOfStocksAfterPurchasesCalculator(StockPrice,SavingAccount,NumberOfStocks);
                    SavingAccount = DataPreparation.SavingAccountAfterPurchasesCalculator(StockPrice,SavingAccount);
                }
                InvestmentRaport.ShowMonthlySummary(Month, Year, NumberOfStocks, StockPrice, SavingAccount);
            }

        }InvestmentRaport.ShowInvestmentSummary(NumberOfStocks, StockPrice, SavingAccount, MonthlySavingAccountAdd, CashAmount, InvestmentDuration);
    }
    public static void main(String[] args) {
        InvestmentCalculator(new BigDecimal(3000), 6, new BigDecimal(5), new BigDecimal(10000), 8,2, new BigDecimal(1000));
    }
}
