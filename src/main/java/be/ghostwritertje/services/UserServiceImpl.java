package be.ghostwritertje.services;

import be.ghostwritertje.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        this.userDao.createUser("Ghostwriter");

        return "Example User";
    }
}
