package com.projet_dinosaurus.dinosaurus.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "toy")
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toy_id", nullable = false)
    private Long id;
    private String name;
    private String description;
    private int user_id;
    private String picture;
    private boolean isAvailable;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User toyOwner;

    @OneToMany(mappedBy = "tradedToy", cascade = CascadeType.ALL)
    private List<Transaction> tradedToys;

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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public User getOwner() {
        return toyOwner;
    }

    public void setOwner(User toyOwner) {
        this.toyOwner = toyOwner;
    }

    public User getToyOwner() {
        return toyOwner;
    }

    public void setToyOwner(User toyOwner) {
        this.toyOwner = toyOwner;
    }

    public List<Transaction> getTradedToys() {
        return tradedToys;
    }

    public void setTradedToys(List<Transaction> tradedToys) {
        this.tradedToys = tradedToys;
    }
}
