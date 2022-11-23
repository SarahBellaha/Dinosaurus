package com.projet_dinosaurus.dinosaurus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name="toy")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Toy implements Serializable {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toy_id", nullable = false)
    private Long id;

    private String name;
    private String description;
    private String picture;
    private boolean available;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @OneToMany(mappedBy = "tradedToy")
    private List<Transaction> tradedToys = new ArrayList<>();

    // ______________

    public Toy () {
    }

    public Toy(String name, String description, String picture, boolean available, User user) {
        this.setName(name);
        this.setDescription(description);
        this.setPicture(picture);
        this.setAvailable(available);
        this.getUser();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public void setAvailable(boolean available) {
        this.available = available;
    }

    public User getUser() {
        return this.user;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
