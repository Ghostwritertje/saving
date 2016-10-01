package be.ghostwritertje.services;

import be.ghostwritertje.dao.repository.PersonDao;
import be.ghostwritertje.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao dao;

    @PostConstruct
    private void postConstruct() {
        this.dao.save(new Person("Ghostwritertje"));
    }

    @Override
    public String getLoggedInUser() {
        return this.dao.findByUsername("Ghostwritertje").getUsername();
    }

    @Override
    public List<Person> findAll() {
        Iterable<Person> userIterable = this.dao.findAll();

        List<Person> personList = new ArrayList<>();
        userIterable.forEach(personList::add);

        return personList;
    }

    @Override
    public Person findByUsername(String username) {
        return this.dao.findByUsername(username);
    }

    @Override
    public Person save(Person person) {
        return this.dao.save(person);
    }

    @Override
    public Person logIn(Person person) {
        return this.dao.findByUsernameAndPassword(person.getUsername(), person.getPassword());
    }


}
