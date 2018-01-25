package com.greenfoxacademy.awesomemixvol.Service;

import com.greenfoxacademy.awesomemixvol.Model.DTO.SongResponseDto;
import com.greenfoxacademy.awesomemixvol.Model.Entity.Song;
import com.greenfoxacademy.awesomemixvol.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceDbImpl implements SongService {
    private final SongRepository songRepository;

    @Autowired
    public SongServiceDbImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void delete(long id) {
        songRepository.delete(id);
    }

    @Override
    public List<Song> findAll() {
        List<Song> songs = new ArrayList<>();
        songRepository.findAll().forEach(songs::add);
        return songs;
    }

    @Override
    public Song findOne(long id) {
        return songRepository.findOne(id);
    }

    public SongResponseDto transfer(Song song) {
        SongResponseDto songResponseDto = new SongResponseDto();
        songResponseDto.setId(song.getId());
        songResponseDto.setTitle(song.getTitle());
        songResponseDto.setGenre(song.getGenre());
        songResponseDto.setRating(song.getRating());
        songResponseDto.setYear(song.getYear());
        return songResponseDto;
    }
}
