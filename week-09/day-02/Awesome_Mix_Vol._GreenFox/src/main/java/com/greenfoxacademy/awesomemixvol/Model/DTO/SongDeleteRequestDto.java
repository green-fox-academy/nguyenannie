package com.greenfoxacademy.awesomemixvol.Model.DTO;

public class SongDeleteRequestDto {
    private long id;

    public SongDeleteRequestDto() {

    }

    public SongDeleteRequestDto(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
