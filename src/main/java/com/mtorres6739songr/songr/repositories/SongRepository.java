package com.mtorres6739songr.songr.repositories;

import com.mtorres6739songr.songr.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
    public Song findByTitle(String title);
}
