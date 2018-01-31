package com.greenfoxacademy.annie.reddit.Entity;

import com.greenfoxacademy.annie.reddit.DTO.PostResponseDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String title;
    private String content;
    private Date creationDate;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    private List<Vote> votes;

    public Post() {
        creationDate = new Date();
        comments = new ArrayList<>();
        votes = new ArrayList<>();
    }

    public Post(User author, String title, String content) {
        this.user = author;
        this.title = title;
        this.content = content;
        creationDate = new Date();
        comments = new ArrayList<>();
        votes = new ArrayList<>();
    }

    public Post(User author, String title) {
        this.user = author;
        this.title = title;
        creationDate = new Date();
        comments = new ArrayList<>();
        votes = new ArrayList<>();
    }

    public PostResponseDTO convert() {
        PostResponseDTO postResponseDTO = new PostResponseDTO();
        postResponseDTO.setId(this.id);
        postResponseDTO.setTitle(this.getTitle());
        postResponseDTO.setTimestamp(this.getCreationDate());
        postResponseDTO.setOwner(this.getUser().getName());
        postResponseDTO.setScore(this.getScore());
        postResponseDTO.setVote(this.getVoteState(getUser()));
        return postResponseDTO;
    }

    public void setUser(User user) {
        setUser(user, true);
    }

    public void setUser(User user, boolean add) {
        this.user = user;
        if (user != null && add) {
            user.addPost(this, false);
        }
    }

    public void addComment(Comment comment) {
        addComment(comment, true);
    }

    public void addComment(Comment comment, boolean set) {
        if (comment!= null) {
            if(getComments().contains(comment)) {
                getComments().set(getComments().indexOf(comment),comment);
            }
            else {
                getComments().add(comment);
            }
            if (set) {
                comment.setPost(this, false);
            }
        }
    }

    public void removeComment(Comment comment) {
        getComments().remove(comment);
        comment.setPost(null);
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if ((object == null) || !(object instanceof Post)) {
            return false;
        }

        final Post post = (Post) object;

        return this.id != 0 && post.getId() != 0 && this.id == post.getId();
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public int getScore() {
        int score = 0;
        if(getVotes().size() == 0) {
            score = 0;
        } else {
            for (int i = 0; i < getVotes().size(); i++) {
                score += getVotes().get(i).getVote();
            }
        }

        return score;
    }

    public int getVoteState(User user) {
        Integer vote = 0;
        for(int i = 0; i < getVotes().size(); i++) {
            if(getVotes().get(i).getUser() == user) {
                vote = getVotes().get(i).getVote();
                break;
            }
        }
        return vote;
    }
}

