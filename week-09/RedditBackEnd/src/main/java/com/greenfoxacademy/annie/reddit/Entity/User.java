package com.greenfoxacademy.annie.reddit.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Vote> votes;

    public User() {
        votes = new ArrayList<>();
        posts = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public void addPost(Post post) {
        addPost(post, true);
    }

    public void addPost(Post post, boolean set) {
        if (post != null) {
            if(getPosts().contains(post)) {
                getPosts().set(getPosts().indexOf(post),post);
            }
            else {
                getPosts().add(post);
            }
            if (set) {
                post.setUser(this, false);
            }
        }
    }

    public void removePost(Post post) {
        getPosts().remove(post);
        post.setUser(null);
    }

    public void addComment(Comment comment) {
        addComment(comment, true);
    }

    public void addComment(Comment comment, boolean set) {
        if (comment != null) {
            if(getComments().contains(comment)) {
                getComments().set(getComments().indexOf(comment), comment);
            }
            else {
                getComments().add(comment);
            }
            if (set) {
                comment.setUser(this, false);
            }
        }
    }

    public void removeComment(Comment comment) {
        getComments().remove(comment);
        comment.setUser(null);
    }

    public void addVote(Vote vote) {

    }

    public void unVote(Vote vote) {
        getVotes().remove(vote);
        vote.setUser(null);
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
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

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if ((object == null) || !(object instanceof User))
            return false;

        final User user = (User) object;

        return this.id != 0 && user.getId() != 0 && id == user.getId();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}

