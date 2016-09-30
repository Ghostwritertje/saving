package be.ghostwritertje.domain;

import javax.persistence.*;

/**
 * Created by Ghostwritertje
 * Date: 29-Sep-16.
 */
@Table(name = "T_USER")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
