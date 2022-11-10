package com.mtorres6739songr.songr.controllers;

import com.mtorres6739songr.songr.models.Album;
import com.mtorres6739songr.songr.models.Song;
import com.mtorres6739songr.songr.repositories.AlbumRepository;
import com.mtorres6739songr.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("/hello")
    public String helloworld() {
        return "hello";
    }

    @GetMapping("/capitalize/{word}")
    public String capitalizeWord(@PathVariable String word, Model m) {
        m.addAttribute("word", word.toUpperCase());
        return "capitalize";
    }


    // Album Mapping
    @GetMapping("/albums")
    public String getAlbums(Model m) {
        List<Album> allAlbums = albumRepository.findAll();
        m.addAttribute("allAlbums", allAlbums);
        return "albums.html";
    }

    @PostMapping("/albums")
    public RedirectView addAlbums(String title, String artist, int songCount, int lengthInSeconds, String imageURL) {
        Album album = new Album(title, artist, songCount, lengthInSeconds, imageURL);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

    // Song Mapping

    @GetMapping("/song")
    public String getAllSongs(Model m) {
        List<Song> song = songRepository.findAll();
        m.addAttribute("song", song);
        return "albums";
    }

    @PostMapping("/addSong")
    public RedirectView addSong(String title, int length, int trackNumber, String albumTitle) {
        Album newAlbum = albumRepository.findByTitle(albumTitle);
        Song newSong = new Song(title, length, trackNumber, newAlbum);
        songRepository.save(newSong);
        return new RedirectView("/albums");
    }

}
