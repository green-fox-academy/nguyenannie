package com.greenfoxacademy.awesomemixvol.Repository;

import com.greenfoxacademy.awesomemixvol.Model.Entity.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
}
