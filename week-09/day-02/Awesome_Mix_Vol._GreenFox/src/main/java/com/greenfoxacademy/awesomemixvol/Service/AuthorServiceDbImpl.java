package com.greenfoxacademy.awesomemixvol.Service;

import com.greenfoxacademy.awesomemixvol.Model.Entity.Author;
import com.greenfoxacademy.awesomemixvol.Model.Entity.Song;
import com.greenfoxacademy.awesomemixvol.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    @Override
    public void addSong(Song song, long id) {
        List<Song> songs = authorRepository.findOne(id).getSongs();
        songs.add(song);
        authorRepository.findOne(id).setSongs(songs);
    }
}
