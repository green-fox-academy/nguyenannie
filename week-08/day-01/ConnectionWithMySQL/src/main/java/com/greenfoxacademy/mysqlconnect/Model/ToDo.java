package com.greenfoxacademy.mysqlconnect.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private boolean urgent;
    private boolean done = false;
    private String creationTime;
    private String description;
    private String duedate;
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "assignee_id")
    private Assignee assignee;

    public Todo() {
        creationTime = String.valueOf(LocalDate.now());
    }

    public Todo(String title) {
        this.title = title;
        urgent = false;
        done = false;
        creationTime = String.valueOf(LocalDate.now());
    }

    public Todo(String title, boolean urgent, boolean done) {
        this.title = title;
        this.urgent = urgent;
        this.done= done;
        creationTime = String.valueOf(LocalDate.now());
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
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

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    public String getDescription() {
        return description;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
