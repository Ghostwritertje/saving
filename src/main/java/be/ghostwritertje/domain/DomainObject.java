package be.ghostwritertje.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
@MappedSuperclass
public abstract class DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
