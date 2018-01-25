package com.greenfoxacademy.awesomemixvol.Controller;

import com.greenfoxacademy.awesomemixvol.Model.DTO.*;
import com.greenfoxacademy.awesomemixvol.Model.DTO.Error;
import com.greenfoxacademy.awesomemixvol.Model.Entity.Author;
import com.greenfoxacademy.awesomemixvol.Model.Entity.Song;
import com.greenfoxacademy.awesomemixvol.Service.AuthorServiceDbImpl;
import com.greenfoxacademy.awesomemixvol.Service.SongServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mixvol")
public class MainController {
    private final SongServiceDbImpl songServiceDb;
    private final AuthorServiceDbImpl authorServiceDb;

    @Autowired
    public MainController(SongServiceDbImpl songServiceDb, AuthorServiceDbImpl authorServiceDb) {
        this.songServiceDb = songServiceDb;
        this.authorServiceDb = authorServiceDb;
    }

    @GetMapping("")
    public ResponseEntity<?> getSongList() {
        return new ResponseEntity<>(songServiceDb.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody SongAddResquestDto songResquestDto) {
        Song song = new Song(songResquestDto.getTitle(), songResquestDto.getGenre(),
                songResquestDto.getYear(), songResquestDto.getRating());
        songServiceDb.save(song);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestBody SongDeleteRequestDto songDeleteRequestDto) {
        Song song = songServiceDb.findOne(songDeleteRequestDto.getId());
        if( song != null) {
            SongResponseDto songResponseDto = songServiceDb.transfer(song);
            songServiceDb.delete(songDeleteRequestDto.getId());
            return new ResponseEntity<>(songResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Error("No such song"), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("")
    public ResponseEntity<?> modifyRating(@RequestBody SongModifyRequestDto songModifyRequestDto,
                                          BindingResult bindingResult) {
        Song song = songServiceDb.findOne(songModifyRequestDto.getId());
        if(song != null) {
            song.setRating(songModifyRequestDto.getRating());
            songServiceDb.save(song);
            return new ResponseEntity<>(song, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Error("No such song"), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/addAuthor")
    public ResponseEntity<?> addAuthor(@RequestBody AuthorAddRequestDto authorAddRequestDto) {
        Song song = songServiceDb.findOne(authorAddRequestDto.getSongid());
        if(song != null) {
            Author author= new Author();
            author.setName(authorAddRequestDto.getName());
            author.setAge(authorAddRequestDto.getAge());
            author.setNationality(authorAddRequestDto.getNationality());
            song.setAuthor(author);
            authorServiceDb.save(author);
            songServiceDb.save(song);
            return new ResponseEntity<>(song, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Error("No such song"), HttpStatus.BAD_REQUEST);
        }
    }

}
