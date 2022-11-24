package com.projet_dinosaurus.dinosaurus.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "city")
    private String city;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Toy> toys = new ArrayList<>();

    /*
     * @OneToMany(mappedBy = "ownerId", cascade = CascadeType.ALL) private List<Transaction>
     * ownedToys;
     * 
     * @OneToMany(mappedBy = "takerId", cascade = CascadeType.ALL) private List<Transaction>
     * reservedToys;
     */

    public User() {}

    public User(String lastname, String email) {
        this.lastname = lastname;
        this.email = email;

    }

    public User(String lastname, String firstname, String city, String email, String password,
            String role) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.city = city;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(Long id, String lastname, String firstname, String city, String email,
            String password, String role) {
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


    /*
     * public List<Transaction> getOwnedToys() { return ownedToys; }
     * 
     * public void setOwnedToys(List<Transaction> ownedToys) { this.ownedToys = ownedToys; }
     * 
     * public List<Transaction> getReservedToys() { return reservedToys; }
     * 
     * public void setReservedToys(List<Transaction> reserved) { this.reservedToys = reserved; }
     */
}
