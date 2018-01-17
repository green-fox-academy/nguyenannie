package com.greenfoxacademy.reddit.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Author {
    private long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Post> posts;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
