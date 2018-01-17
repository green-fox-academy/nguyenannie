package com.greenfoxacademy.reddit;

import com.greenfoxacademy.reddit.Model.User;
import com.greenfoxacademy.reddit.Model.Comment;
import com.greenfoxacademy.reddit.Model.Post;
import com.greenfoxacademy.reddit.Repository.UserRepository;
import com.greenfoxacademy.reddit.Service.CommentServiceDbImpl;
import com.greenfoxacademy.reddit.Service.PostServiceDbImpl;
import com.greenfoxacademy.reddit.Service.UserServiceDbImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedditApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedditApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CommentServiceDbImpl commentServiceDb,
                                  PostServiceDbImpl postServiceDb, UserServiceDbImpl userServiceDb) {
        return (String... args) -> {
        };
    }
}

    /*
            User user1 = new User("Annie");
            User user2 = new User("Rubble");
            User user3 = new User("Sonic");
            User user4 = new User("Krisz");
            User user5 = new User("Bea");
            User user6 = new User("Sally");
            User user7 = new User("John");
            User user8 = new User("LadyKiller");
            User user9 = new User("handsomeboy_903");
            User user10 = new User("CuteDog");

            Post post1 = new Post(user1, "Cat is the best animal", "Cat gif", 500);
            Post post2 = new Post(user2, "2018 hair trend", "weird hair", 150);
            Post post3 = new Post(user3, "Tinder memes", "click to see more", 299);
            Post post4 = new Post(user4, "Jumping over a parachute", "he was nearly dead", 189);
            Post post5 = new Post(user5, "That was unexpected", "yeeeep", 357);
            Post post6 = new Post(user4, "Handsome guy fixes his wife's code", "Incredible", 12537);

            Comment comment1 = new Comment(user6, post1,"You sucks");
            Comment comment2 = new Comment(user7, post2,"lol");
            Comment comment3 = new Comment(user8, post3,"hahahhaha");
            Comment comment4 = new Comment(user9, post4,"Poor you");
            Comment comment5 = new Comment(user10, post5,"That is not trueeeee!!!");

            userServiceDb.save(user1);
            userServiceDb.save(user2);
            userServiceDb.save(user3);
            userServiceDb.save(user4);
            userServiceDb.save(user5);
            userServiceDb.save(user6);
            userServiceDb.save(user7);
            userServiceDb.save(user8);
            userServiceDb.save(user9);
            userServiceDb.save(user10);

            postServiceDb.save(post1);
            postServiceDb.save(post2);
            postServiceDb.save(post3);
            postServiceDb.save(post4);
            postServiceDb.save(post5);
            postServiceDb.save(post6);

            commentServiceDb.save(comment1);
            commentServiceDb.save(comment2);
            commentServiceDb.save(comment3);
            commentServiceDb.save(comment4);
            commentServiceDb.save(comment5);
            */
