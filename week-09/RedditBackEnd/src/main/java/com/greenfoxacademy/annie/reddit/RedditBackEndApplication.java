package com.greenfoxacademy.annie.reddit;

import com.greenfoxacademy.annie.reddit.Model.Comment;
import com.greenfoxacademy.annie.reddit.Model.Post;
import com.greenfoxacademy.annie.reddit.Model.User;
import com.greenfoxacademy.annie.reddit.Service.CommentServiceDbImpl;
import com.greenfoxacademy.annie.reddit.Service.PostServiceDbImpl;
import com.greenfoxacademy.annie.reddit.Service.UserServiceDbImpl;
import com.greenfoxacademy.annie.reddit.Service.VoteServiceDbImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedditBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditBackEndApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(PostServiceDbImpl postServiceDb, CommentServiceDbImpl commentServiceDb,
                                  UserServiceDbImpl userServiceDb, VoteServiceDbImpl voteServiceDb) {
        return (String... args) -> {

        };
    }

	/*
	        User user1 = new User("natsdof", "12345");
            User user2 = new User("John", "iamnotfat");
            User user3 = new User("BigA", "idonteatalot");
            User user4 = new User("Mark", "iamsuperhandsome");
            User user5 = new User("Belli", "lovedrawing");
            User user6 = new User("fondetti", "idontknowwhoiam");
            User user7 = new User("sugardaddy", "madeupperson");
            User user8 = new User("catlover", "notkilllady");
            User user9 = new User("hotboy090", "12345");
            User user10 = new User("niceguy898", "donthatecat");
            User user11 = new User("Annie", "12345");
            User user12 = new User("Rubble", "iamnotfat");
            User user13 = new User("Sonic", "idonteatalot");
            User user14 = new User("Krisz", "iamsuperhandsome");
            User user15 = new User("Bea", "lovedrawing");
            User user16 = new User("Sally", "idontknowwhoiam");
            User user17 = new User("John", "madeupperson");
            User user18 = new User("LadyKiller", "notkilllady");
            User user19 = new User("handsomeboy_903", "12345");
            User user20 = new User("CuteDog", "donthatecat");


            Post post1 = new Post(user1, "She doesn't skip leg day", "Hot Body");
            Post post2 = new Post(user4, "On the journey to success", "Only keep it trill...");
            Post post3 = new Post(user6, "The name of this ice-cream", "Nogger");
            Post post4 = new Post(user8, "He took one look at my bio and ran with it",
                    "Pretty straight forword, not looking for anything serious. " +
                            "If you dont believe in climate change, and/or your are Trump supporter, swipe left");
            Post post5 = new Post(user9, "Sadly #NoRepply", "Do you speak Russian? " +
                    "No but i can sepak English if that is fine for you");
            Post post7 = new Post(user13, "Handsome guy debugs his wife's code", "Incredible");
            Post post8 = new Post(user10, "If you were a vegetable", "If you were a vegetable," +
                    "you would be a cute-cumber");
            Post post9 = new Post(user17, "", "Incredible");
            Post post10 = new Post(user11, "We can all relate to this one", "When she comes home...");
            Post post11 = new Post(user14, "Not all cats hate water", "He willingly jumped into the bath tub :)");
            Post post12 = new Post(user12, "Who's the fuck wrote this book????", "True Faith and Allegiance");
            Post post13 = new Post(user10, "This uncut dorito", "i have more than i can imagine");
            Post post14 = new Post(user19, "", "Incredible");
            Post post15 = new Post(user15, "Bill Gates with the first version of " +
                    "Microsoft Windows 1980s", "Historical Moment");
            Post post16 = new Post(user16, "Cat is the best animal", "Cat gif");
            Post post17 = new Post(user2, "2018 hair trend", "weird hair");
            Post post18 = new Post(user5, "Tinder memes", "click to see more");
            Post post19 = new Post(user3, "Jumping over a parachute", "he was nearly dead");
            Post post20 = new Post(user7, "That was unexpected", "yeeeep");
            Post post6 = new Post(user18, "Cool dog actions", "Incredible");


            Comment comment1 = new Comment(user6, post1,"It's so weirdddd");
            Comment comment2 = new Comment(user7, post11,"I wish you're gonna get better buddy. Too bad!");
            Comment comment3 = new Comment(user8, post3,"Why's it funny? What's wrong with you people");
            Comment comment4 = new Comment(user9, post12,"Wowwwww");
            Comment comment5 = new Comment(user10, post5,"That's what she said");
            Comment comment6 = new Comment(user18, post1,"You sucks");
            Comment comment7 = new Comment(user16, post2,"lol");
            Comment comment8 = new Comment(user11, post4,"hahahhaha");
            Comment comment9 = new Comment(user20, post6,"Poor you");
            Comment comment10 = new Comment(user13, post5,"That is not trueeeee!!!");

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
            userServiceDb.save(user11);
            userServiceDb.save(user12);
            userServiceDb.save(user13);
            userServiceDb.save(user14);
            userServiceDb.save(user15);
            userServiceDb.save(user16);
            userServiceDb.save(user17);
            userServiceDb.save(user18);
            userServiceDb.save(user19);
            userServiceDb.save(user20);

            postServiceDb.save(post1);
            postServiceDb.save(post2);
            postServiceDb.save(post3);
            postServiceDb.save(post4);
            postServiceDb.save(post5);
            postServiceDb.save(post7);
            postServiceDb.save(post8);
            postServiceDb.save(post9);
            postServiceDb.save(post10);
            postServiceDb.save(post11);
            postServiceDb.save(post12);
            postServiceDb.save(post13);
            postServiceDb.save(post14);
            postServiceDb.save(post15);
            postServiceDb.save(post16);
            postServiceDb.save(post17);
            postServiceDb.save(post18);
            postServiceDb.save(post19);
            postServiceDb.save(post20);
            postServiceDb.save(post6);

            commentServiceDb.save(comment1);
            commentServiceDb.save(comment2);
            commentServiceDb.save(comment3);
            commentServiceDb.save(comment4);
            commentServiceDb.save(comment5);
            commentServiceDb.save(comment6);
            commentServiceDb.save(comment7);
            commentServiceDb.save(comment8);
            commentServiceDb.save(comment9);
            commentServiceDb.save(comment10);
	 */
}
