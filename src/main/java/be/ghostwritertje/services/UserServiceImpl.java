package be.ghostwritertje.services;

import be.ghostwritertje.dao.UserDao;
import be.ghostwritertje.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public String getLoggedInUser() {
        return this.userDao.save(new User("Ghostwritertje")).getUsername();
    }

    @Override
    public List<User> findAll() {
        Iterable<User> userIterable =  this.userDao.findAll();

        List<User> userList = new ArrayList<>();
        userIterable.forEach(userList::add);

        return userList;
    }


}
