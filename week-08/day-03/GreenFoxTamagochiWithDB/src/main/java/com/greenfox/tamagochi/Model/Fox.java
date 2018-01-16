package com.greenfox.tamagochi.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Fox {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String food;
    private String drink;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Tamagochier tamagochier;

    @ManyToMany(
            targetEntity = Trick.class,
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "foxes"
    )
    private List<Trick> tricks = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTricks(List<Trick> tricks) {
        this.tricks = tricks;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFood() {
        return food;
    }

    public String getDrink() {
        return drink;
    }

    public List<Trick> getTricks() {
        return tricks;
    }

    public Tamagochier getTamagochier() {
        return tamagochier;
    }

    public void setTamagochier(Tamagochier tamagochier) {
        this.tamagochier = tamagochier;
    }

}
