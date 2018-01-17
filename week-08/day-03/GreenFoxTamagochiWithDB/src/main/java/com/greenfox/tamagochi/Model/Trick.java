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

    @OneToMany
    private List<FoxTrickAssociation> foxs = new ArrayList<>();

    public Trick() {

    }

    public Trick(String name, String description) {
        this.name = name;
        this.description = description;
    }

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

    public List<FoxTrickAssociation> getFoxs() {
        return foxs;
    }

    public void setFoxs(List<FoxTrickAssociation> foxs) {
        this.foxs = foxs;
    }

    @Override
    public String toString() {
        return this.getName();
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
