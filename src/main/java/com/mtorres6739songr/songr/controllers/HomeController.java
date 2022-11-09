package com.mtorres6739songr.songr.controllers;

import com.mtorres6739songr.songr.models.Album;
import com.mtorres6739songr.songr.repositories.AlbumRepository;
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

//    @GetMapping("/albums")
//    public String getThreeAlbums(Model m) {
//        String albumString = threeAlbums();
//
//        m.addAttribute("albumString", albumString);
//        return "albums";
//    }


    @GetMapping("/albums")
    public String getAlbums(Model m) {
        List<Album> allAlbums = albumRepository.findAll();
        m.addAttribute("allAlbums", allAlbums);
        return "albums.html";
    }

    @PostMapping("/albums")
    public RedirectView addAlbums(String albumTitle, String albumArtist, int songCount, int lengthInSeconds, String imageUrl) {
        Album album = new Album(albumTitle, albumArtist, songCount, lengthInSeconds, imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

    private String threeAlbums() {
        Album[] threeAlbums = new Album[3];
        threeAlbums[0] = new Album("Mr. Pintstripe Suite", "Big Bad Voodoo Daddy", 12, 218, "https://m.media-amazon.com/images/I/71NWXlCORYL._UX500_FMwebp_QL85_.jpg");
        threeAlbums[1] = new Album("King of Swing", "Big Bad Voodoo Daddy", 12, 299, "https://m.media-amazon.com/images/I/71NWXlCORYL._UX500_FMwebp_QL85_.jpg");
        threeAlbums[2] = new Album("Minnie The Moocher", "Big Bad Voodoo Daddy", 12, 283, "https://m.media-amazon.com/images/I/71NWXlCORYL._UX500_FMwebp_QL85_.jpg");

        String albumString = threeAlbums[0].albumString() + ",\n" + threeAlbums[1].albumString() + ",\n" + threeAlbums[2].albumString();
        return albumString;
    }

}
