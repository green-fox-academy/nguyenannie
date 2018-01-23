package com.greenfoxacademy.annie.reddit.Model;

import javax.persistence.*;

@Entity
@Table
public class Vote {
//    private long id;

    @ManyToOne(fetch= FetchType.LAZY, cascade= CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch= FetchType.LAZY, cascade= CascadeType.MERGE)
    @JoinColumn(name = "post_id")
    private Post post;

    private boolean upvote;
//
//    public Vote(long id) {
//        this.id = id;
//    }

    public Vote(User user, Post post) {
        this.user = user;
        this.post = post;
    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public boolean isUpvote() {
        return upvote;
    }

    public void setUpvote(boolean upvote) {
        this.upvote = upvote;
    }
}
