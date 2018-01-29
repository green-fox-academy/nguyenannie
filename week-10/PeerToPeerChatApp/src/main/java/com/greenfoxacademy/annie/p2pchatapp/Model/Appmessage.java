package com.greenfoxacademy.annie.p2pchatapp.Model;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime timestamp;

    public Appmessage(Appuser appuser, String text) {
        this.appuser = appuser;
        this.text = text;
        this.timestamp = LocalDateTime.now();
        this.id = UniqueRandomNumber.generate();
    }

    public Appmessage() {
        this.timestamp = LocalDateTime.now();
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "id: " + this.id + " message: " + this.text + " user: " + appuser.getName()
                + " timestamp: " + this.timestamp;
    }
}
