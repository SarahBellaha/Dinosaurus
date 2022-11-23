package com.projet_dinosaurus.dinosaurus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name="user")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="lastname")
    private String lastname;

    @Column(name="firstname")
    private String firstname;

    @Column(name="city")
    private String city;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private String role;

    // __________ toys ___________

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Toy> toys = new ArrayList<>();

    // __________ Transactions _____________

    //          --- Reserved ---

    @OneToMany(mappedBy = "toyTaker")
    @JsonIgnore
    private List<Transaction> reservedToys = new ArrayList<>();

    // _____________________________________

    public User() {
    }

    public User(String lastname, String firstname, String city, String email, String password, String role) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.city = city;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(Long id, String lastname, String firstname, String city, String email, String password, String role) {
        this.setId(id);
        this.lastname = lastname;
        this.firstname = firstname;
        this.city = city;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // --------  Getters / Setters of relations ---------

    //                 -----  Toys  -----

    public List<Toy> getToys() {
        return toys;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }

    //               -----  Transactions  -----

    public List<Transaction> getReservedToys() {
        return reservedToys;
    }

    public void setReservedToys(List<Transaction> reservedToys) {
        this.reservedToys = reservedToys;
    }
}
