package com.mtorres6739songr.songr.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    private String title;
    private String artist;
    private int songCount;
    private int lengthInSeconds;
    private String imageURL;

    public Album() {}

    public Album(String title, String artist, int songCount, int lengthInSeconds, String imageURL) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.lengthInSeconds = lengthInSeconds;
        this.imageURL = imageURL;
    }

    public String albumString() {
        return String.format("Album: %s, Artist: %s, Song #: %s, Song Length: %s",
                this.title, this.artist, this.songCount, this.lengthInSeconds);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}
