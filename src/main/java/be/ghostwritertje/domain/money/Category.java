package be.ghostwritertje.domain.money;

import be.ghostwritertje.domain.DomainObject;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Jorandeboever
 * Date: 01-Oct-16.
 */
@Entity
@Table(name = "T_CATEGORY")
public class Category extends DomainObject {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
