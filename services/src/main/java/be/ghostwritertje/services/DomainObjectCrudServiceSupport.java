package be.ghostwritertje.services;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */

import be.ghostwritertje.domain.DomainObject;
import org.springframework.data.repository.CrudRepository;

public abstract class DomainObjectCrudServiceSupport<T extends DomainObject> implements DomainObjectCrudService<T> {

    protected abstract CrudRepository<T, Integer> getDao();

    public T findOne(Integer id) {
        return this.getDao().findOne(id);
    }

    @Override
    public void delete(T object) {
        this.getDao().delete(object);
    }

    public T save(T object) {
        return this.getDao().save(object);
    }
}
