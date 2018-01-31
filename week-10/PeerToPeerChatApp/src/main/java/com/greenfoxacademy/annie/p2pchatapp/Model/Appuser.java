package com.greenfoxacademy.annie.p2pchatapp.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Appuser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true, nullable = false)
    private String username;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appuser")
    private List<Appmessage> appmessages;

    public Appuser() {

    }

    public Appuser(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Appmessage> getMessages() {
        return appmessages;
    }

    public void setMessages(List<Appmessage> appmessages) {
        this.appmessages = appmessages;
    }

    @Override
    public String toString() {
        return "Appuser " + id + " " + username;
    }
}
