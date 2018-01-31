package com.greenfoxacademy.annie.reddit.Controller;

import com.greenfoxacademy.annie.reddit.DTO.UserInfoDTO;
import com.greenfoxacademy.annie.reddit.Entity.Post;
import com.greenfoxacademy.annie.reddit.Entity.User;
import com.greenfoxacademy.annie.reddit.Service.PostServiceDbImpl;
import com.greenfoxacademy.annie.reddit.Service.UserServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class UserController {
    private final UserServiceDbImpl userServiceDb;
    private final PostServiceDbImpl postServiceDb;

    @Autowired
    public UserController(UserServiceDbImpl userServiceDb, PostServiceDbImpl postServiceDb) {
        this.userServiceDb = userServiceDb;
        this.postServiceDb = postServiceDb;
    }

    @GetMapping("")
    public ResponseEntity<?> getUserInfo(@RequestParam(value = "name") String name) {
        User user = userServiceDb.findByName(name);
        if(user != null) {
            UserInfoDTO userInfoDTO = new UserInfoDTO(user);
            return new ResponseEntity<>(userInfoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Error("Username is not in the database"), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("")
    public void getUserInfo(@RequestParam(value = "name") String name,
                                         @RequestParam(value = "id") long id) {
        User user = userServiceDb.findByName(name);
        Post post = postServiceDb.findOne(id);
        if(user != null && post != null) {

        }
    }


}
