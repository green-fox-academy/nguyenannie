package com.greenfoxacademy.mysqlconnect.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private boolean urgent;
    private boolean done = false;
    private String creation_time;

    public ToDo() {
        creation_time = String.valueOf(LocalDate.now());
    }

    public ToDo(String title) {
        this.title = title;
        urgent = false;
        done = false;
        creation_time = String.valueOf(LocalDate.now());
    }

    public ToDo(String title, boolean urgent, boolean done) {
        this.title = title;
        this.urgent = urgent;
        this.done= done;
        creation_time = String.valueOf(LocalDate.now());
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public boolean isDone() {
        return done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
