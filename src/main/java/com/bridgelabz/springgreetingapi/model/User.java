package com.bridgelabz.springgreetingapi.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String userGreeting;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserGreeting() {
        return userGreeting;
    }

    public void setUserGreeting(String userGreeting) {
        this.userGreeting = userGreeting;
    }
}
