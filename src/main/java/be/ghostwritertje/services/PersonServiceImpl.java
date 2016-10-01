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
    private PersonDao personDao;

    @PostConstruct
    private void postConstruct() {
        this.personDao.save(new Person("Ghostwritertje"));
    }

    @Override
    public String getLoggedInUser() {
        return this.personDao.findByUsername("Ghostwritertje").getUsername();
    }

    @Override
    public List<Person> findAll() {
        Iterable<Person> userIterable = this.personDao.findAll();

        List<Person> personList = new ArrayList<>();
        userIterable.forEach(personList::add);

        return personList;
    }

    @Override
    public Person findByUsername(String username) {
        return this.personDao.findByUsername(username);
    }


}
