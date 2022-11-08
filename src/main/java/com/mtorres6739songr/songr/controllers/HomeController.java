package com.mtorres6739songr.songr.controllers;

import com.mtorres6739songr.songr.models.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class HomeController {
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

    @GetMapping("/albums")
    public String getThreeAlbums(Model m) {
        String albumString = threeAlbums();

        m.addAttribute("albumString", albumString);
        return "albums";
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
