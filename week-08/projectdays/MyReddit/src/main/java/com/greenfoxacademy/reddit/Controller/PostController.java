package com.greenfoxacademy.reddit.Controller;

import com.greenfoxacademy.reddit.Model.Comment;
import com.greenfoxacademy.reddit.Model.Post;
import com.greenfoxacademy.reddit.Model.User;
import com.greenfoxacademy.reddit.Service.CommentServiceDbImpl;
import com.greenfoxacademy.reddit.Service.PostServiceDbImpl;
import com.greenfoxacademy.reddit.Service.UserServiceDbImpl;
import javafx.geometry.Pos;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {
    private final CommentServiceDbImpl commentServiceDb;
    private final PostServiceDbImpl postServiceDb;
    private final UserServiceDbImpl userServiceDb;

    @Autowired
    public PostController(CommentServiceDbImpl commentServiceDb, PostServiceDbImpl postServiceDb, UserServiceDbImpl userServiceDb) {
        this.commentServiceDb = commentServiceDb;
        this.postServiceDb = postServiceDb;
        this.userServiceDb = userServiceDb;
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(Model model, HttpServletRequest request) {
        String result;
        String usernameinput = request.getParameter("username");
        String userpasswordinput = request.getParameter("password");

        long id = userServiceDb.findByName(usernameinput).getId();
        User user = userServiceDb.findByName(usernameinput);

        if(userServiceDb.exists(id) && userServiceDb.findByName(usernameinput).getPassword().equals(userpasswordinput)) {
            result = "redirect:/home/" + usernameinput;
        } else {
            result = "cannotlogin";
        }

        model.addAttribute("user", user);
        return result;
    }

    @GetMapping("/home/{username}")
    public String getHome(Model model, HttpServletRequest request, @PathVariable(value = "username") String username, Pageable pageable) {
        User user = userServiceDb.findByName(username);
        List<Post> posts = postServiceDb.findAll();
        //Page<Post> posts = postServiceDb.findByPage(pageable);

        model.addAttribute("user", user);
        model.addAttribute("posts", posts);

        return "home";
    }

    @PostMapping("/home/upvote/{username}/{id}")
    public String postUpvote(Model model, HttpServletRequest request, @PathVariable(value = "id") String id, @PathVariable(value = "username") String username) {
        Post post = postServiceDb.findOne(Long.parseLong(id));

        int score = post.getScore();
        score += 1;
        post.setScore(score);

        postServiceDb.save(post);

        return "redirect:/home/" + username;
    }

    @PostMapping("/home/downvote/{username}/{id}")
    public String postDownvote(Model model, HttpServletRequest request, @PathVariable(value = "id") String id, @PathVariable(value = "username") String username) {
        Post post = postServiceDb.findOne(Long.parseLong(id));

        int score = post.getScore();
        score -= 1;
        post.setScore(score);

        postServiceDb.save(post);

        return "redirect:/home/" + username;
    }

    @GetMapping("/home/{username}/createpost")
    public String getAdd(Model model, HttpServletRequest request, @PathVariable(value = "username") String username) {
        User user = userServiceDb.findByName(username);
        model.addAttribute("user", user);

        return "createpost";
    }

    @PostMapping("/home/{username}/createpost")
    public String postAdd(Model model, HttpServletRequest request, @PathVariable(value = "username") String username) {
        User user = userServiceDb.findByName(username);
        model.addAttribute("user", user);

        String title = request.getParameter("addtitle");
        String content = request.getParameter("addcontent");

        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setContent(content);
        user.addPost(newPost);
        newPost.setUser(user);

        userServiceDb.save(user);
        postServiceDb.save(newPost);

        return "redirect:/home/" + username;
    }

    @GetMapping("/{username}/post/{postid}")
    public String getPostDetail(Model model, HttpServletRequest request,
                                @PathVariable(value = "username") String username,
                                @PathVariable(value = "postid") String id) {

        User user = userServiceDb.findByName(username);
        model.addAttribute("user", user);

        Post post = postServiceDb.findOne(Long.parseLong(id));
        model.addAttribute("post", post);
        model.addAttribute("comments", post.getComments());
        return "postdetail";
    }

    @PostMapping("/{username}/post/{postid}/comment")
    public String postComment(Model model, HttpServletRequest request,
                              @PathVariable(value = "username") String username,
                              @PathVariable(value = "postid") String id) {
        Post post = postServiceDb.findOne(Long.parseLong(id));
        User user = userServiceDb.findByName(username);

        String commentContent = request.getParameter("addcomment");
        Comment newComment = new Comment();

        newComment.setContent(commentContent);
        newComment.setPost(post);
        newComment.setUser(user);

        user.addComment(newComment);
        post.addComment(newComment);

        userServiceDb.save(user);
        postServiceDb.save(post);
        commentServiceDb.save(newComment);

        model.addAttribute("user", user);
        model.addAttribute("post", post);
        return "redirect:/" + username + "/post/" + id;
    }

    @GetMapping("/account/{username}")
    public String getUserInfo(Model model, @PathVariable(value = "username") String username) {
        User user = userServiceDb.findByName(username);

        model.addAttribute("myposts", user.getPosts());
        model.addAttribute("postnum", user.getPosts().size());
        model.addAttribute("mycomments", user.getComments());
        model.addAttribute("commentnum", user.getComments().size());
        model.addAttribute("user", user);

        return "userinfo";
    }

    @PostMapping("/account/{username}/{postid}/delete")
    public String deletePost(@PathVariable(value = "username") String username, @PathVariable(value = "postid") String postid) {
        
        return "redirect:/" + username + "/" + postid + "/delete";
    }


    @GetMapping("/account/{username}/changepassword")
    public String getchangePassword(Model model,
                                    @PathVariable(value = "username") String username) {
        User user = userServiceDb.findByName(username);
        model.addAttribute("user", user);

        return "changepassword";
    }

    @PostMapping("/account/{username}/changepassword")
    public String postUserPassword(Model model,
                                   @PathVariable(value = "username") String username,
                                   HttpServletRequest request) {

        String result;
        User user = userServiceDb.findByName(username);

        String newPassword = request.getParameter("changepassword");
        String confirmPassword = request.getParameter("confirmpassword");

        if(newPassword != null && newPassword.equals(confirmPassword) && !newPassword.equals(user.getPassword())) {
            user.setPassword(newPassword);
            userServiceDb.save(user);
            result = "redirect:/account" + username;
        } else {
            result = "cantchangeit";
        }
        model.addAttribute("user", user);

        return result;
    }

}
