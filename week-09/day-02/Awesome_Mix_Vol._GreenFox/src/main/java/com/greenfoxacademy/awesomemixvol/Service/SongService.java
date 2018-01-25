package com.greenfoxacademy.awesomemixvol.Service;

import com.greenfoxacademy.awesomemixvol.Model.Entity.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SongService {
    void save(Song song);
    void delete(long id);
    List<Song> findAll();
    Song findOne(long id);
}
