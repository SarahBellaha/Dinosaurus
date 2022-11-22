package com.projet_dinosaurus.dinosaurus.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long ownerId;

    private String lastname;

    private String firstname;

    private String city;

    private String email;

    private String password;

    private String role;

    @OneToMany( targetEntity = Toy.class, mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Toy> toys;

    @OneToMany(mappedBy = "ownerId", cascade = CascadeType.ALL)
    private List<Transaction> ownedToys;

    @OneToMany(mappedBy = "takerId", cascade = CascadeType.ALL)
    private List<Transaction> reservedToys;

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

    public User(Long ownerId, String lastname, String firstname, String city, String email, String password, String role) {
        this.setOwnerId(ownerId);
        this.lastname = lastname;
        this.firstname = firstname;
        this.city = city;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
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

    public List<Toy> getToys() {
        return toys;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }

    public List<Transaction> getOwnedToys() {
        return ownedToys;
    }

    public void setOwnedToys(List<Transaction> ownedToys) {
        this.ownedToys = ownedToys;
    }

    public List<Transaction> getReservedToys() {
        return reservedToys;
    }

    public void setReservedToys(List<Transaction> reserved) {
        this.reservedToys = reserved;
    }
}
