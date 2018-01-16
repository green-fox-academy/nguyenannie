package com.greenfox.tamagochi.Model;

import javax.persistence.*;

@Entity
@Table
public class Tamagochier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String password;
    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "tamagochier")
    private Fox fox;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Fox getFox() {
        return fox;
    }

    public void setFox(Fox fox) {
        this.fox = fox;
    }
}
