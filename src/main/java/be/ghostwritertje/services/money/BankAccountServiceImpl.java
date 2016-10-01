package be.ghostwritertje.services.money;

import be.ghostwritertje.dao.repository.BankAccountDao;
import be.ghostwritertje.domain.Person;
import be.ghostwritertje.domain.money.BankAccount;
import be.ghostwritertje.services.DomainObjectReadServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
@Service
public class BankAccountServiceImpl extends DomainObjectReadServiceSupport<BankAccount> implements BankAccountService {
    @Autowired
    private BankAccountDao dao;

    @Override
    protected CrudRepository<BankAccount, Integer> getDao() {
        return this.dao;
    }

    @Override
    public List<BankAccount> findByOwner(Person owner) {
        return this.dao.findByOwner(owner);
    }
}
