package com.greenfoxacademy.reddit;

import com.greenfoxacademy.reddit.Model.Author;
import com.greenfoxacademy.reddit.Model.Comment;
import com.greenfoxacademy.reddit.Model.Post;
import com.greenfoxacademy.reddit.Repository.AuthorRepository;
import com.greenfoxacademy.reddit.Service.CommentServiceDbImpl;
import com.greenfoxacademy.reddit.Service.PostServiceDbImpl;
import com.greenfoxacademy.reddit.Service.UserServiceDbImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class RedditApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CommentServiceDbImpl commentServiceDb, UserServiceDbImpl userServiceDb,
                                  PostServiceDbImpl postServiceDb, AuthorRepository authorRepository) {
		return (String... args) -> {
            Post post1 = new Post("Cat is the best animal", "Cat gif", 500);
            Post post2 = new Post("2018 hair trend", "weird hair", 150);
            Post post3 = new Post("Tinder memes", "click to see more", 299);
            Post post4 = new Post("Jumping over a parachute", "he was nearly dead", 189);
            Post post5 = new Post("That was unexpected", "yeeeep", 357);

            Author author1 = new Author("Annie");
            Author author2 = new Author("Rubble");
            Author author3 = new Author("Sonic");
            Author author4 = new Author("Krisz");
            Author author5 = new Author("Bea");
            Author author6 = new Author("Sally");
            Author author7 = new Author("John");
            Author author8 = new Author("LadyKiller");
            Author author9 = new Author("handsomeboy_903");
            Author author10 = new Author("CuteDog");

            Comment comment1 = new Comment("You sucks");
            Comment comment2 = new Comment("lol");
            Comment comment3 = new Comment("hahahhaha");
            Comment comment4 = new Comment("Poor you");
            Comment comment5 = new Comment("That is not trueeeee!!!");

            post1.setAuthor(author1);
            post2.setAuthor(author5);
            post3.setAuthor(author4);
            post4.setAuthor(author2);
            post5.setAuthor(author3);

            post1.setComments(Arrays.asList(comment1, comment2));
            post3.setComments(Arrays.asList(comment5, comment3));
            post2.setComments(Arrays.asList(comment5, comment4));
            post4.setComments(Arrays.asList(comment3, comment2));
            post3.setComments(Arrays.asList(comment1, comment5));

            comment1.setAuthor(author6);
            comment1.setAuthor(author9);
            comment1.setAuthor(author7);
            comment1.setAuthor(author8);
            comment1.setAuthor(author10);

            postServiceDb.save(post1);
            postServiceDb.save(post2);
            postServiceDb.save(post3);
            postServiceDb.save(post4);
            postServiceDb.save(post5);

            authorRepository.save(author1);
            authorRepository.save(author2);
            authorRepository.save(author3);
            authorRepository.save(author4);
            authorRepository.save(author5);
            authorRepository.save(author6);
            authorRepository.save(author7);
            authorRepository.save(author8);
            authorRepository.save(author9);
            authorRepository.save(author10);

            commentServiceDb.save(comment1);
            commentServiceDb.save(comment2);
            commentServiceDb.save(comment3);
            commentServiceDb.save(comment4);
            commentServiceDb.save(comment5);
        };
	}
}
