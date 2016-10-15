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

    @Override
    protected CrudRepository<Stock, Integer> getDao() {
        return this.stockDao;
    }
}
