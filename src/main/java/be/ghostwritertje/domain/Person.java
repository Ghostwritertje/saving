package be.ghostwritertje.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
@Table(name = "T_PERSON")
@Entity
public class Person extends DomainObject {

    private String username;
    private String password;

    public Person() {
    }

    public Person(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
