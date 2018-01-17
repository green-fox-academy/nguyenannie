package com.greenfoxacademy.reddit.Service;

import com.greenfoxacademy.reddit.Model.Author;
        import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    void save(Author author);
}
