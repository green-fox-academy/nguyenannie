package com.greenfoxacademy.annie.reddit.DTO;

import com.greenfoxacademy.annie.reddit.Entity.Post;
import com.greenfoxacademy.annie.reddit.Entity.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PostResponseDTO {
    private long id;
    private String title;
    private String url;
    private Date timestamp;
    private int score;
    private String owner;
    private int vote;

    public PostResponseDTO() {

    }

    public PostResponseDTO(Post post, User user) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.url = "http://localhost:8080/posts?username=" + user.getName();
        this.timestamp = post.getCreationDate();
        this.score = post.getScore();
        this.owner = user.getName();
        this.vote = post.getVoteState(user);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
