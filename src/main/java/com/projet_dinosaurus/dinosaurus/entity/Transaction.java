package com.projet_dinosaurus.dinosaurus.entity;

import javax.persistence.*;

@Entity(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User ownerId;

    private Long takerId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "toy_id", insertable = false, updatable = false)
    private Toy toyId;

    public Transaction() {
    }

    public Transaction(User ownerId, Toy toyId, Long takerId){
        this.ownerId = ownerId;
        this.toyId = toyId;
        this.takerId = takerId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getTaker() {
        return takerId;
    }

    public void setTaker(Long taker) {
        this.takerId = takerId;
    }

    public Toy getTradedToy() {
        return toyId;
    }

    public void setTradedToy(Toy toyId) {
        this.toyId = toyId;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }
}
