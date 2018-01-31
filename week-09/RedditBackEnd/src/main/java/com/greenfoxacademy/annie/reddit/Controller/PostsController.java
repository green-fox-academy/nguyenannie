package com.greenfoxacademy.annie.reddit.Controller;

import com.greenfoxacademy.annie.reddit.DTO.Error;
import com.greenfoxacademy.annie.reddit.DTO.PostRequestDTO;
import com.greenfoxacademy.annie.reddit.DTO.PostResponseDTO;
import com.greenfoxacademy.annie.reddit.DTO.VoteResponseDTO;
import com.greenfoxacademy.annie.reddit.Entity.Comment;
import com.greenfoxacademy.annie.reddit.Entity.Post;
import com.greenfoxacademy.annie.reddit.Entity.User;
import com.greenfoxacademy.annie.reddit.Entity.Vote;
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
@CrossOrigin("*")
@RequestMapping("/posts")
public class PostsController {

    private final CommentServiceDbImpl commentServiceDb;
    private final PostServiceDbImpl postServiceDb;
    private final UserServiceDbImpl userServiceDb;
    private final VoteServiceDbImpl voteServiceDb;

    @Autowired
    public PostsController(CommentServiceDbImpl commentServiceDb, PostServiceDbImpl postServiceDb,
                           UserServiceDbImpl userServiceDb, VoteServiceDbImpl voteServiceDb) {
        this.commentServiceDb = commentServiceDb;
        this.postServiceDb = postServiceDb;
        this.userServiceDb = userServiceDb;
        this.voteServiceDb = voteServiceDb;
    }

    @GetMapping("")
    public ResponseEntity<List<PostResponseDTO>> getPosts(@RequestHeader(value = "owner") String owner) {

        List<Post> posts = postServiceDb.findAll();
        List<PostResponseDTO> postsResponses = new ArrayList<>();
        User user = userServiceDb.findByName(owner);
        for(Post post : posts) {
            PostResponseDTO postsResponse = new PostResponseDTO(post, user);
            postsResponses.add(postsResponse);
        }
        return new ResponseEntity<>(postsResponses, HttpStatus.OK);
    }

    @PutMapping("/{id}/upvote")
    public ResponseEntity<VoteResponseDTO> upvote(@RequestHeader(value = "owner") String owner,
                                                  @PathVariable(value = "id") long id) {

        User user = userServiceDb.findByName(owner);
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
        return new ResponseEntity<>(new VoteResponseDTO(post, user), HttpStatus.OK);
    }

    @PutMapping("/{id}/downvote")
    public ResponseEntity<VoteResponseDTO> downvote(@RequestHeader(value = "owner") String owner,
                                                    @PathVariable(value = "id") long id) {

        User user = userServiceDb.findByName(owner);
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
        return new ResponseEntity<>(new VoteResponseDTO(post, user), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<PostResponseDTO> createPost(@RequestHeader(value = "owner") String owner,
                                                      @RequestBody PostRequestDTO postRequestBody) {
        String title = postRequestBody.getTitle();
        String url = postRequestBody.getUrl();

        User user = userServiceDb.findByName(owner);
        Post post = new Post();
        post.setUser(user);
        post.setTitle(title);
        postServiceDb.save(post);
        userServiceDb.save(user);

        PostResponseDTO postsResponse = new PostResponseDTO(post, user);
        postsResponse.setUrl(url);

        return new ResponseEntity<>(postsResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@RequestHeader(value = "owner") String owner,
                                    @PathVariable(value = "id") long id)  {
        User user = userServiceDb.findByName(owner);
        Post post = postServiceDb.findOne(id);
        User userResponse = post.getUser();

        if(user == userResponse) {
            PostResponseDTO postResponseDTO = post.convert();

            List<Comment> comments = post.getComments();
            List<Vote> votes = post.getVotes();

            for (Comment comment : comments) {
                commentServiceDb.delete(comment.getId());
            }

            for (Vote vote : votes) {
                voteServiceDb.delete(vote);
            }

            postServiceDb.delete(id);
            postResponseDTO.setUrl("http://localhost:8080/posts?username=" + user.getName());

            return new ResponseEntity<>(postResponseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Error("You don't have the right " +
                                                                "to delete this post"), HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyTitle(@RequestHeader(value = "owner") String owner,
                                                   @PathVariable(value = "id") long id,
                                                   @RequestBody PostRequestDTO postRequestDTO)  {
        User user = userServiceDb.findByName(owner);
        Post post = postServiceDb.findOne(id);
        User userResponse = post.getUser();

        if(user == userResponse) {
            post.setTitle(postRequestDTO.getTitle());
            postServiceDb.save(post);
            PostResponseDTO postResponseDTO = new PostResponseDTO(post, userResponse);
            postResponseDTO.setUrl(postRequestDTO.getUrl());
            return new ResponseEntity<>(postResponseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Error("You dont have " +
                                                                "the right to modify this post"), HttpStatus.OK);
        }
    }
}
