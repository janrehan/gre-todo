package com.gre.todo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Created by Jan_R on 5/5/2017.
 */

@Entity
@Table
public class AppUser implements Serializable {

    public AppUser() {

    };

    public AppUser(String login) {
        this.login = login;

    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}