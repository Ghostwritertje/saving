package be.ghostwritertje.dao.repository;

import be.ghostwritertje.domain.money.Statement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
@Repository
public interface StatementDao extends CrudRepository<Statement, Integer> {
}
