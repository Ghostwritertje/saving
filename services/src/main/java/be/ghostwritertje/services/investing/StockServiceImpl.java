package be.ghostwritertje.services.investing;

import be.ghostwritertje.domain.investing.Stock;
import be.ghostwritertje.repository.StockDao;
import be.ghostwritertje.services.DomainObjectCrudServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Jorandeboever
 * Date: 15-Oct-16.
 */
@Service
public class StockServiceImpl extends DomainObjectCrudServiceSupport<Stock> implements StockService {

    @Autowired
    private StockDao stockDao;

    @Autowired
    private FinanceService financeService;

    @Override
    protected CrudRepository<Stock, Integer> getDao() {
        return this.stockDao;
    }

    @Override
    public Stock save(Stock object) {
        if(this.financeService.exists(object.getQuote())) {
            return super.save(object);
        } else {
            return null;
        }
    }

}
