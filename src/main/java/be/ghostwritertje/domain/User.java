package be.ghostwritertje.domain;

import javax.persistence.*;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
@Table(name = "USER")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }
}
