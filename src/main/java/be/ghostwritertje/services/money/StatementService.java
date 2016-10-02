package be.ghostwritertje.services.money;

import be.ghostwritertje.domain.BankAccount;
import be.ghostwritertje.domain.Person;
import be.ghostwritertje.domain.Statement;
import be.ghostwritertje.services.DomainObjectReadService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public interface StatementService extends DomainObjectReadService<Statement> {

    Iterable<Statement> save(Iterable<Statement> statements);

    List<Statement> findAll(Person administrator);

    BigDecimal getTotal(BankAccount bankAccount);

    BigDecimal getTotal(Person owner);
}
