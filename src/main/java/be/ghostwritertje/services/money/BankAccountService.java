package be.ghostwritertje.services.money;

import be.ghostwritertje.domain.Person;
import be.ghostwritertje.domain.money.BankAccount;
import be.ghostwritertje.services.DomainObjectReadService;

import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public interface BankAccountService extends DomainObjectReadService<BankAccount> {
    List<BankAccount> findByOwner(Person owner);
}
