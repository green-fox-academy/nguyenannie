package com.greenfoxacademy.annie.p2pchatapp.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Appuser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true, nullable = false)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appuser")
    private List<Appmessage> appmessages;

    public Appuser() {

    }

    public Appuser(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Appmessage> getMessages() {
        return appmessages;
    }

    public void setMessages(List<Appmessage> appmessages) {
        this.appmessages = appmessages;
    }

    @Override
    public String toString() {
        return "Appuser " + id + " " + name;
    }
}
