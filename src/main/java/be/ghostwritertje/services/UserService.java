package be.ghostwritertje.services;

import be.ghostwritertje.domain.User;

import java.util.List;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
public interface UserService {
    String getLoggedInUser();

    List<User> findAll();
}
