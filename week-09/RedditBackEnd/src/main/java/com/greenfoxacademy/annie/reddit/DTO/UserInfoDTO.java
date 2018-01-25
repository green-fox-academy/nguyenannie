package com.greenfoxacademy.annie.reddit.DTO;

import com.greenfoxacademy.annie.reddit.Model.Entity.Comment;
import com.greenfoxacademy.annie.reddit.Model.Entity.Post;
import com.greenfoxacademy.annie.reddit.Model.Entity.User;
import com.greenfoxacademy.annie.reddit.Model.Entity.Vote;

import java.util.List;

public class UserInfoDTO {
    private String name;
    private String password;
    private List<Post> posts;
    private List<Comment> comments;
    private List<Vote> votes;

    public UserInfoDTO() {

    }

    public UserInfoDTO(User user) {
        this.name = user.getName();
        this.password = user.getPassword();
        this.posts = user.getPosts();
        this.comments = user.getComments();
        this.votes = user.getVotes();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
