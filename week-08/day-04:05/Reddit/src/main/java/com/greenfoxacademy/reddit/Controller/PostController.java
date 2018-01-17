package com.greenfoxacademy.reddit.Controller;

import com.greenfoxacademy.reddit.Service.CommentServiceDbImpl;
import com.greenfoxacademy.reddit.Service.PostServiceDbImpl;
import com.greenfoxacademy.reddit.Service.UserServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
    private final CommentServiceDbImpl commentServiceDb;
    private final UserServiceDbImpl userServiceDb;
    private final PostServiceDbImpl postServiceDb;

    @Autowired
    public PostController(CommentServiceDbImpl commentServiceDb, UserServiceDbImpl userServiceDb, PostServiceDbImpl postServiceDb) {
        this.commentServiceDb = commentServiceDb;
        this.userServiceDb = userServiceDb;
        this.postServiceDb = postServiceDb;
    }

    @GetMapping(value = {"/reddit"})
    public String showmainpage(Model model) {
        return "mainpage";
    }

}
