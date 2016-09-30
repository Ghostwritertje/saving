package be.ghostwritertje.dao.repository;

import be.ghostwritertje.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

/*    User createOrUpdate(String username);

    List<User> findAll();

    User get(String username);*/
}
