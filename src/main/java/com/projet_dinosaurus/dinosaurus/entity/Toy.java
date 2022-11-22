package com.projet_dinosaurus.dinosaurus.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "toy")
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toy_id", nullable = false)
    private Long id;
    @Column( insertable=false, updatable=false)
    private String name;
    private String description;
    private String picture;
    private boolean available;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "name")
    private User owner;

    @OneToMany(mappedBy = "toyId", cascade = CascadeType.ALL)
    private List<Transaction> tradedToys;

    public Toy () {
    }

    public Toy(String name, String description, String picture, boolean available, User ownerId) {
        this.setName(name);
        this.setDescription(description);
        this.setPicture(picture);
        this.setAvailable(available);
        this.setOwnerId(ownerId);
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

    public boolean available() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwnerId(User ownerId) {
        this.owner = owner;
    }

    public List<Transaction> getTradedToys() {
        return tradedToys;
    }

    public void setTradedToys(List<Transaction> tradedToys) {
        this.tradedToys = tradedToys;
    }
}
