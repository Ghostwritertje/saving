package be.ghostwritertje.dao.repository;

import be.ghostwritertje.domain.Person;
import be.ghostwritertje.domain.money.BankAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public interface BankAccountDao extends CrudRepository<BankAccount, Integer> {

    List<BankAccount> findByOwner(Person owner);
}
