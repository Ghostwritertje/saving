package be.ghostwritertje.services;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */

import be.ghostwritertje.domain.DomainObject;
import org.springframework.data.repository.CrudRepository;

public abstract class DomainObjectReadServiceSupport<T extends DomainObject> implements DomainObjectReadService<T> {

    protected abstract CrudRepository<T, Integer> getDao();

    public T findOne(Integer id) {
        return this.getDao().findOne(id);
    }
}
