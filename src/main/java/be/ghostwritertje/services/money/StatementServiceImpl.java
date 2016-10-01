package be.ghostwritertje.services.money;

import be.ghostwritertje.dao.repository.StatementDao;
import be.ghostwritertje.domain.Person;
import be.ghostwritertje.domain.Statement;
import be.ghostwritertje.services.DomainObjectReadServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
@Service
public class StatementServiceImpl extends DomainObjectReadServiceSupport<Statement> implements StatementService {
    @Autowired
    private StatementDao dao;

    @Autowired
    private BankAccountService bankAccountService;

    @Override
    protected CrudRepository<Statement, Integer> getDao() {
        return this.dao;
    }

    @PostConstruct
    public void postConstruct() {
        this.dao.save(new Statement());
    }

    @Override
    public Iterable<Statement> save(Iterable<Statement> statements) {
        return this.dao.save(statements);
    }

    @Override
    public List<Statement> findAll(Person administrator) {
        List<Statement> statements = new ArrayList<>();
        this.bankAccountService.findByAdministrator(administrator).forEach(bankAccount -> statements.addAll(this.dao.findByFrom(bankAccount)));
        return statements;
    }
}
