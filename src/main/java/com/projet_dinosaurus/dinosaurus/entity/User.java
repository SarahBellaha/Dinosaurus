package com.projet_dinosaurus.dinosaurus.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Doit implémenter Serializable car une référence à un objet User est présent dans Toy
// Et pour faire un GET sur un Toy, il faut dire à Hibernate comment sérialiser la réference User
// Pas d'implementation de méthode = serialization par défaut de Java
@Entity(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "number_of_toys")
    private int getNumberOfToys() {
        return this.toys.size();
    }

    // Relation 1..n
    // mappedBy -> pour dire à Hibernate qu'une référence à cette entité est appellée "user" dans
    // l'autre entité jointe
    @OneToMany(mappedBy = "user")
    private List<Toy> toys = new ArrayList<>();

    public User() {

    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addToy(Toy toy) {
        this.toys.add(toy);
        toy.setUser(this);
    }

    public void removeToy(Toy toy) {
        this.toys.remove(toy);
        toy.setUser(null);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
