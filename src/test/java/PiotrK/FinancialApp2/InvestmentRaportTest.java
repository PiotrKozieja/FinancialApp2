package PiotrK.FinancialApp2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.io.ByteArrayOutputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class InvestmentRaportTest {
    @Test
    public void isShowMonthlySummaryCorrect() {
        int month = 1;
        int year = 2024;
        BigDecimal numberOfStocks = new BigDecimal(100);
        BigDecimal stockPrice = new BigDecimal(10.5);
        BigDecimal savingAccount = new BigDecimal(5000.00);
        String expectedOutput = String.format("%02d.%02d", month, year) + "    " +
                "NOS: " + String.format("%04d", numberOfStocks.intValue()) + "       StockP: " +
                new DecimalFormat("#,###.00").format(stockPrice) + "      SValue: " +
                new DecimalFormat("#,###.00").format(numberOfStocks.multiply(stockPrice)) + "   SavingAcc: " +
                new DecimalFormat("#,###.00").format(savingAccount);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream(); //Ten obiekt działa jak bufor w pamięci, do którego będzie zapisywany tekst, zamiast być wyświetlany bezpośrednio na konsoli.
        System.setOut(new PrintStream(outContent)); //Przekierowuje strumień wyjścia standardowego (System.out) na obiekt PrintStream, który zapisuje w buforze outContent.
        InvestmentRaport.ShowMonthlySummary(month, year, numberOfStocks, stockPrice, savingAccount);
        System.setOut(System.out);//Przywraca wyjście standardowe do oryginalnego stanu, czyli z powrotem na konsolę.
        assert(expectedOutput.equals(outContent.toString().trim()) );
    }

}
