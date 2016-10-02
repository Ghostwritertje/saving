package be.ghostwritertje.dao.repository;

import be.ghostwritertje.domain.BankAccount;
import be.ghostwritertje.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public interface BankAccountDao extends CrudRepository<BankAccount, Integer> {

    List<BankAccount> findByAdministrator(Person administrator);

    List<BankAccount> findByOwner(Person owner);

    @Override
    <S extends BankAccount> Iterable<S> save(Iterable<S> entities);
}
