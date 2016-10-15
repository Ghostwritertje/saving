package be.ghostwritertje.repository;

import be.ghostwritertje.domain.investing.FinancialInstrument;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 15-Oct-16.
 */
@Repository
public interface FinancialInstrumentDao extends CrudRepository<FinancialInstrument, Integer> {
    FinancialInstrument findByQuote(String quote);

    @Query(value = "FROM FinancialInstrument f")
    List<FinancialInstrument> findFinancialInstrumentsWithoutHistory();
}
