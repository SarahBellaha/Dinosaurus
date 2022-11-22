package com.projet_dinosaurus.dinosaurus.entity;

import com.projet_dinosaurus.dinosaurus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity(name = "toys")
public class Toy {
    // @Transient pour ne pas sauvegarder cette propriété dans la table SQL
    // (sinon Hibernate le fait pour toutes les propriétés déclarées
    @Transient
    public Long userId;

    // @Column(name = "") pour forcer Hibernate à utiliser ce nom pour la colonne dans la table
    // (sinon par defaut -> snake_case du nom de la propriété)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toy_id")
    private Long id;
    private String name;
    private String description;

    // @ManyToOne pour dire à Hibernate qu'il y a une relation n..1 entre cette entité et une autre
    // FetchType.LAZY pour dire à Hibernate de ne pas chercher la valeur automatiquement... à un moment...
    @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn pour dire à Hibernate de créer une colonne dans la table de l'entité courante
    // mais que cette colonne vient d'une clé externe
    // name + referencedColumnName pour dire de prendre la valeur de "referencedColumnName" de la clé externe
    // (ici, Users), et de la mettre dans une colonne "name" de cette entité (ici, Toy)
    @JoinColumn(name = "user_first_name", referencedColumnName = "first_name")
    private User user;

    public Toy() {

    }

    public Toy(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
