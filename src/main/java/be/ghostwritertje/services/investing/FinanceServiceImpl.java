package be.ghostwritertje.services.investing;

import be.ghostwritertje.domain.investing.FundPurchase;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 08-Oct-16.
 */
@Service
public class FinanceServiceImpl implements FinanceService {
    private static final Logger logger = Logger.getLogger(FinanceServiceImpl.class);

    @Override
    public Double getTotalPortfolio(List<FundPurchase> fundPurchases) {
        return fundPurchases.stream().map(this::getCurrentvalue).mapToDouble(Number::doubleValue).sum();
    }

    public static void main(String[] args) {
        Stock tesla = null;
        try {
            tesla = YahooFinance.get("SWDA.MI");

            System.out.println(tesla.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BigDecimal getCurrentvalue(FundPurchase fundPurchase) {
        try {
            return YahooFinance.get(fundPurchase.getQuote()).getQuote().getPrice().multiply(BigDecimal.valueOf(fundPurchase.getNumberOfShares()));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("STOCKPRICE NOT FOUND! IOEXCEPTION");
            return BigDecimal.ZERO;
        }
    }
}
