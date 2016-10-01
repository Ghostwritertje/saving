package be.ghostwritertje.dao.repository;

import be.ghostwritertje.domain.BankAccount;
import be.ghostwritertje.domain.Statement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
@Repository
public interface StatementDao extends CrudRepository<Statement, Integer> {

    List<Statement> findByFrom(BankAccount from);
}
