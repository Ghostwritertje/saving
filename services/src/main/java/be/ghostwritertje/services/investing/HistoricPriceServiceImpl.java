package be.ghostwritertje.services.investing;

import be.ghostwritertje.domain.investing.HistoricPrice;
import be.ghostwritertje.repository.HistoricPriceDao;
import be.ghostwritertje.services.DomainObjectCrudServiceSupport;
import be.ghostwritertje.utilities.DateUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jorandeboever
 * Date: 15-Oct-16.
 */
@Service
public class HistoricPriceServiceImpl extends DomainObjectCrudServiceSupport<HistoricPrice> implements HistoricPriceService {
    @Autowired
    private HistoricPriceDao historicPriceDao;

    @Autowired
    private FinanceService financeService;

    @Override
    protected CrudRepository<HistoricPrice, Integer> getDao() {
        return this.historicPriceDao;
    }

    public void initHistoricPricesForStock(String quote) {
        this.save(this.financeService.getHistoricalQuotes(quote));
    }


}
