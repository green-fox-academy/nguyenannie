package com.greenfoxacademy.annie.reddit.Controller;

import com.greenfoxacademy.annie.reddit.Model.Post;
import com.greenfoxacademy.annie.reddit.Model.User;
import com.greenfoxacademy.annie.reddit.Model.Vote;
import com.greenfoxacademy.annie.reddit.Responses.PostsResponse;
import com.greenfoxacademy.annie.reddit.Responses.VoteResponse;
import com.greenfoxacademy.annie.reddit.Service.CommentServiceDbImpl;
import com.greenfoxacademy.annie.reddit.Service.PostServiceDbImpl;
import com.greenfoxacademy.annie.reddit.Service.UserServiceDbImpl;
import com.greenfoxacademy.annie.reddit.Service.VoteServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    private final CommentServiceDbImpl commentServiceDb;
    private final PostServiceDbImpl postServiceDb;
    private final UserServiceDbImpl userServiceDb;
    private final VoteServiceDbImpl voteServiceDb;

    @Autowired
    public MainController(CommentServiceDbImpl commentServiceDb, PostServiceDbImpl postServiceDb, UserServiceDbImpl userServiceDb, VoteServiceDbImpl voteServiceDb) {
        this.commentServiceDb = commentServiceDb;
        this.postServiceDb = postServiceDb;
        this.userServiceDb = userServiceDb;
        this.voteServiceDb = voteServiceDb;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostsResponse>> getPosts(@RequestParam(value = "username") String username) {

        List<Post> posts = postServiceDb.findAll();
        List<PostsResponse> postsResponses = new ArrayList<>();
        User user = userServiceDb.findByName(username);
        for(Post post : posts) {
            PostsResponse postsResponse = new PostsResponse(post, user);
            postsResponses.add(postsResponse);
        }
        return new ResponseEntity<>(postsResponses, HttpStatus.OK);
    }

    @PostMapping("/posts/{id}/upvote")
    public ResponseEntity<VoteResponse> upvote(@RequestParam(value = "username") String username,
                                               @PathVariable(value = "id") long id) {

        User user = userServiceDb.findByName(username);
        Post post = postServiceDb.findOne(id);
        Vote vote = voteServiceDb.findByPostAndUser(post, user);

        if(vote == null) {
            Vote upvote = new Vote(user,post, 1);
            voteServiceDb.save(upvote);
        } else if(vote.getVote() == -1) {
            vote.setVote(1);
            voteServiceDb.save(vote);
        } else {
            post.getVotes().remove(vote);
            voteServiceDb.delete(vote);
        }

        postServiceDb.save(post);
        return new ResponseEntity<>(new VoteResponse(post, user), HttpStatus.OK);
    }

    @PostMapping("posts/{id}/downvote")
    public ResponseEntity<VoteResponse> downvote(@RequestParam(value = "username") String username,
                                                @PathVariable(value = "id") long id) {

        User user = userServiceDb.findByName(username);
        Post post = postServiceDb.findOne(id);
        Vote vote = voteServiceDb.findByPostAndUser(post, user);

        if(vote == null) {
            Vote downvote = new Vote(user,post, -1);
            voteServiceDb.save(downvote);
        } else if(vote.getVote() == 1) {
            vote.setVote(-1);
            voteServiceDb.save(vote);
        } else {
            post.getVotes().remove(vote);
            voteServiceDb.delete(vote);
        }

        postServiceDb.save(post);
        return new ResponseEntity<>(new VoteResponse(post, user), HttpStatus.OK);
    }
}
