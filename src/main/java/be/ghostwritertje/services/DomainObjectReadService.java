package be.ghostwritertje.services;

import be.ghostwritertje.domain.DomainObject;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
public interface DomainObjectReadService<T extends DomainObject> {
    public T findOne(Integer id);
}
