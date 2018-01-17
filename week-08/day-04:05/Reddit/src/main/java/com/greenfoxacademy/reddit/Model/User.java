package com.greenfoxacademy.reddit.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String password;
    private int numofposts;
    private int numofcomments;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Comment> comments;

    public User() {
    }

    public int getNumofcomments() {
        return numofcomments;
    }

    public void setNumofcomments(int numofcomments) {
        this.numofcomments = numofcomments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getNumofposts() {
        return numofposts;
    }

    public void setNumofposts(int numofposts) {
        this.numofposts = numofposts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
