package com.greenfoxacademy.annie.p2pchatapp.Model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table
public class Appmessage {
    @Id
    @Column(unique = true, nullable = false)
    private long id;
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name = "appuser_id")
    private Appuser appuser;
    private String text;
    private Instant timestamp;

    public Appmessage(Appuser appuser, String text) {
        this.appuser = appuser;
        this.text = text;
        this.timestamp = Instant.now();
        this.id = UniqueRandomNumber.generate();
    }

    public Appmessage(Appuser appuser, String text, long id, Instant timestamp) {
        this.appuser = appuser;
        this.text = text;
        this.timestamp = timestamp;
        this.id = id;
    }

    public Appmessage() {
        this.timestamp = Instant.now();
        this.id = UniqueRandomNumber.generate();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Appuser getAppuser() {
        return appuser;
    }

    public void setAppuser(Appuser appuser) {
        this.appuser = appuser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "id: " + this.id + " message: " + this.text + " user: " + appuser.getUsername()
                + " timestamp: " + this.timestamp;
    }
}
