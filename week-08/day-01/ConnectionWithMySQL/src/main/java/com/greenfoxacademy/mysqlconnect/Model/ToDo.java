package com.greenfoxacademy.mysqlconnect.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private boolean isUrgent;
    private boolean isDone;

    protected ToDo() {

    }

    public ToDo(String title) {
        this.title = title;
        isUrgent = false;
        isDone = false;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isDone() {
        return isDone;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setUrgent(boolean urgent) {
        isUrgent = urgent;
    }

    @Override
    public String toString() {
        return String.format("Todo[id=%d, title = %s, is urgent? %b, is done? %b]", id, title, isUrgent, isDone);
    }
}
