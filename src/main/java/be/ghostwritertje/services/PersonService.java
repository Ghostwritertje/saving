package be.ghostwritertje.services;

import be.ghostwritertje.domain.Person;

import java.util.List;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
public interface PersonService {
    String getLoggedInUser();

    List<Person> findAll();

    Person findByUsername(String username);

    Person save(Person person);

    Person logIn(Person person);
}
