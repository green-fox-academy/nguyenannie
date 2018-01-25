package com.greenfoxacademy.awesomemixvol.Model.DTO;

public class AuthorAddRequestDto {
    private long songid;
    private String name;
    private String nationality;
    private int age;

    public AuthorAddRequestDto() {

    }

    public long getSongid() {
        return songid;
    }

    public void setSongid(long songid) {
        this.songid = songid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
