package be.ghostwritertje.dao.repository;

import be.ghostwritertje.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
@Repository
public interface PersonDao extends CrudRepository<Person, Integer> {

/*    Person createOrUpdate(String username);

    List<Person> findByOwner();

    Person get(String username);*/
}
