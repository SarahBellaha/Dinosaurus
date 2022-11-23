package com.projet_dinosaurus.dinosaurus.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false)
    private Long id;

    // --------- TEST ---------
    private Long toyOwnerId;

    public Long getToyOwnerId() {
        return toyOwnerId;
    }

    public void setToyOwnerId(Long toyOwnerId) {
        this.toyOwnerId = toyOwnerId;
    }

    // __________________________________

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "traded_toy_id", referencedColumnName = "toy_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Toy tradedToy;

    //                 ___ USERS ___

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "taker_user_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User toyTaker;


    //___________________________________

    public Transaction() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ---------- Getters // setters relations -------------


    public Toy getTradedToy() {
        return tradedToy;
    }

    public void setTradedToy(Toy tradedToy) {
        this.tradedToy = tradedToy;
    }


    public User getToyTaker() {
        return toyTaker;
    }

    public void setToyTaker(User toyTaker) {
        this.toyTaker = toyTaker;
    }
}
