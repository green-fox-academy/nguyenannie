package com.greenfoxacademy.awesomemixvol.Model.DTO;

public class SongModifyRequestDto {
    private long id;
    private double rating;

    public SongModifyRequestDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
