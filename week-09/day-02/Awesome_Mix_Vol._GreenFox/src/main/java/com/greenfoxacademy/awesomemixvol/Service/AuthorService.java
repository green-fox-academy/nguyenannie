package com.greenfoxacademy.awesomemixvol.Service;

import com.greenfoxacademy.awesomemixvol.Model.Entity.Author;
import com.greenfoxacademy.awesomemixvol.Model.Entity.Song;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    void save(Author author);
    void addSong(Song song, long id);
}
