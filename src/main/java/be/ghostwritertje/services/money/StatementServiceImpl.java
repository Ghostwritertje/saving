package be.ghostwritertje.services.money;

import be.ghostwritertje.dao.repository.StatementDao;
import be.ghostwritertje.domain.money.Statement;
import be.ghostwritertje.services.DomainObjectReadServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
@Service
public class StatementServiceImpl extends DomainObjectReadServiceSupport<Statement> implements StatementService {
    @Autowired
    private StatementDao dao;

    @Override
    protected CrudRepository<Statement, Integer> getDao() {
        return this.dao;
    }
}
