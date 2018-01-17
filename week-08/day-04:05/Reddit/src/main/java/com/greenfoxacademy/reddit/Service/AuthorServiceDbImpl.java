package com.greenfoxacademy.reddit.Service;

import com.greenfoxacademy.reddit.Model.Author;
import com.greenfoxacademy.reddit.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorServiceDbImpl implements AuthorService{
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceDbImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }
}
