package com.greenfoxacademy.mysqlconnect.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Assignee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignee")
    private List<Todo> toDos = new ArrayList<>();

    public Assignee() {

    }

    public Assignee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public List<Todo> getToDos() {
        return toDos;
    }

    public void setToDos(List<Todo> toDos) {
        this.toDos = toDos;
    }
}
