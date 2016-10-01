package be.ghostwritertje.services.person;

import be.ghostwritertje.domain.Person;
import be.ghostwritertje.services.DomainObjectReadService;

import java.util.List;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
public interface PersonService extends DomainObjectReadService<Person> {
    String getLoggedInUser();

    List<Person> findAll();

    Person findByUsername(String username);

    Person save(Person person);

    Person logIn(Person person);
}
