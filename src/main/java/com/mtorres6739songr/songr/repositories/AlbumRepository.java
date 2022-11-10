package com.mtorres6739songr.songr.repositories;

import com.mtorres6739songr.songr.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    public Album findByTitle(String title);

}
