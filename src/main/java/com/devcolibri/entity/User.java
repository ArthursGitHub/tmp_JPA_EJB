package com.devcolibri.entity;

import javax.persistence.*;

@Entity
@Table(name = "ex21_customer")
@NamedQueries({
        @NamedQuery(name = "findAll", query = "select c from User c"),
})

public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_ID")
    private long id;

    @Column(name = "first_name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private int age;

    public User() {
    }
    public User(String name, String lastName, int age) {

        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}