package be.ghostwritertje.mongo.dao;

import be.ghostwritertje.mongo.domain.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Jorandeboever
 * Date: 10-Oct-16.
 */
public interface StockRepository extends MongoRepository<Stock, String> {
    Stock findByQuote(String quote);
}
