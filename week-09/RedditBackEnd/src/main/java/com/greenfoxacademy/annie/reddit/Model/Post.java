package com.greenfoxacademy.annie.reddit.Model;

import javax.persistence.*;
import java.time.LocalDate;
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
    private String creationDate;
    private Vote vote;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    private List<Vote> votes;

    public Post() {
        creationDate = String.valueOf(LocalDate.now());
    }

    public Post(User author, String title, String content, int score) {
        this.user = author;
        this.title = title;
        this.content = content;
        creationDate = String.valueOf(LocalDate.now());
    }

    public void setUser(User user) {
        setUser(user, true);
    }

    void setUser(User user, boolean add) {
        this.user = user;
        if (user != null && add) {
            user.addPost(this, false);
        }
    }

    public void addComment(Comment comment) {
        addComment(comment, true);
    }

    void addComment(Comment comment, boolean set) {
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

    public void upvote(User user) {
        //Vote vote = votes.find(v -> v.user == user)
        //if (vote == null)
        //  votes.add(new Vote(user, this, true));
        //else if(!vote.isUpvote)
        //  vote.isUpvote = true
        //  votes.save(vote)
        //else //vote is upvote
        //  votes.delete(vote); // if u want to unvote the upvote
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
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

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}

