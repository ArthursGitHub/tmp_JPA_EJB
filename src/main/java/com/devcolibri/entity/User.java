package com.devcolibri.entity;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex21_customer")
@NamedQueries({
        @NamedQuery(name = "findAll", query = "select c from User c"),
        @NamedQuery(name = User.FIND_ALL, query = "select c from User c"),
        @NamedQuery(name = "findVincent", query = "select c from User c where c.firstName = 'Vincent'"),
        @NamedQuery(name = "findWithParam", query = "select c from User c where c.firstName = :fname")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "findAllNative", query = "select * from JPQL_EX01_CUSTOMER", resultClass = User.class)
})
public class User {

    public static final String FIND_ALL = "Customer.findAll";

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;


    // ======================================
    // =            Constructors            =
    // ======================================

    public User() {
    }

    public User(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}