package com.projet_dinosaurus.dinosaurus.entity;

import javax.persistence.*;

@Entity(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "owner_id", insertable = false, updatable = false)
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "taker_id", insertable = false, updatable = false)
    private User taker;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "traded_toy", insertable = false, updatable = false)
    private Toy tradedToy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getTaker() {
        return taker;
    }

    public void setTaker(User taker) {
        this.taker = taker;
    }

    public Toy getTradedToy() {
        return tradedToy;
    }

    public void setTradedToy(Toy tradedToy) {
        this.tradedToy = tradedToy;
    }
}
