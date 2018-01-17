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

    @OneToMany
    private List<FoxTrickAssociation> tricks = new ArrayList<>();

    public Fox() {

    }

    public void addTrick(Trick trick) {
        FoxTrickAssociation foxTrick = new FoxTrickAssociation();
        foxTrick.setFoxAss(this);
        foxTrick.setTrickAss(trick);
        foxTrick.setFoxIdAss(this.getId());
        foxTrick.setTrickIdAss(trick.getId());
        tricks.add(foxTrick);
    }

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

    public void setTricks(List<FoxTrickAssociation> tricks) {
        this.tricks = tricks;
    }

    public void addTrick(FoxTrickAssociation trick) {
        System.out.println("PRE addTrick " + trick + " : " + this.tricks);
        this.tricks.add(trick);
        System.out.println("POST addTrick " + this.tricks);
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

    public List<FoxTrickAssociation> getTricks() {
        return tricks;
    }

    public Tamagochier getTamagochier() {
        return tamagochier;
    }

    public void setTamagochier(Tamagochier tamagochier) {
        this.tamagochier = tamagochier;
    }

    public int getNumOfTricks() {
        return getTricks().size();
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " and food: " + this.getFood()
                + " and drink " + this.getDrink() + " and list of tricks: " + this.getTricks();
    }
}

/*
package com.greenfox.tamagochi.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Trick {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String description;
    @ManyToMany(
            targetEntity = Fox.class,
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private List<Fox> foxes = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public List<Fox> getFoxes() {
        return foxes;
    }

    public void setFoxes(List<Fox> foxes) {
        this.foxes = foxes;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
 */
