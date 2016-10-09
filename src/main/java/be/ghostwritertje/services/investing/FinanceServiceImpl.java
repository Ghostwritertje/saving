package be.ghostwritertje.services.investing;

import be.ghostwritertje.domain.investing.FundPurchase;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

/**
 * Created by Jorandeboever
 * Date: 08-Oct-16.
 */
@Service
public class FinanceServiceImpl implements FinanceService {
    private static final Logger logger = Logger.getLogger(FinanceServiceImpl.class);

    @Override
    public Double getTotalPortfolio(List<FundPurchase> fundPurchases) {
        return fundPurchases.stream().map(this::getCurrentTotalValue).mapToDouble(Number::doubleValue).sum();
    }

    public BigDecimal getPriceAtDate(FundPurchase fundPurchase) {
        LocalDate date = fundPurchase.getDate();
        if (date.isEqual(LocalDate.now())) {
            return this.getCurrentValue(fundPurchase);
        } else {
            Calendar calendar = new GregorianCalendar(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
            try {
                Stock stock = YahooFinance.get("SWDA.MI", calendar, calendar, Interval.DAILY);
                return Optional.ofNullable(stock.getHistory().get(0)).map(HistoricalQuote::getClose).orElse(BigDecimal.ZERO);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return BigDecimal.ZERO;

    }

    @Override
    public InvestmentSummary calculateInvestmentSummary(List<FundPurchase> fundPurchaseList) {
        InvestmentSummary summary = new InvestmentSummary();
        summary.setCurrentValue(BigDecimal.valueOf(getTotalPortfolio(fundPurchaseList)));
        summary.setFundPurchaseList(fundPurchaseList);
        return summary;
    }

    public BigDecimal getCurrentTotalValue(FundPurchase fundPurchase) {
        return this.getCurrentValue(fundPurchase).multiply(BigDecimal.valueOf(fundPurchase.getNumberOfShares()));
    }

    public BigDecimal getCurrentValue(FundPurchase fundPurchase) {
        try {
            if (fundPurchase.getQuote().isEmpty()) {
                return BigDecimal.ZERO;
            }
            return Optional.ofNullable(YahooFinance.get(fundPurchase.getQuote())).map(stock -> stock.getQuote().getPrice()).orElse(BigDecimal.ZERO);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("STOCKPRICE NOT FOUND! IOEXCEPTION");
            return BigDecimal.ZERO;
        }
    }
}
