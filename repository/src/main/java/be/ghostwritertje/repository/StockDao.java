package be.ghostwritertje.repository;

import be.ghostwritertje.domain.investing.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jorandeboever
 * Date: 15-Oct-16.
 */
@Repository
public interface StockDao extends CrudRepository<Stock, Integer> {
}
