package com.mtorres6739songr.songr.models;



import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String title;
    private int length;
    private int trackNumber;

    @ManyToOne
    Album myAlbum;

    public Song() {}

    public Song(String title, int length, int trackNumber, Album myAlbum) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.myAlbum = myAlbum;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Album getMyAlbum() {
        return myAlbum;
    }

    public void setMyAlbum(Album myAlbum) {
        this.myAlbum = myAlbum;
    }
}
