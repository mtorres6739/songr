package com.mtorres6739songr.songr;

import com.mtorres6739songr.songr.models.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testForCreateAlbum() {
		Album sut = new Album("Title", "Artist", 12, 200, "IMG URL");
		assertNotNull(sut);
	}

	@Test
	void testForGetter() {
		Album sut = new Album("Title", "Artist", 12, 200, "IMG URL");
		assertEquals("Title", sut.getTitle());
		assertEquals("Artist", sut.getArtist());
		assertEquals(12, sut.getSongCount());
		assertEquals(200, sut.getLengthInSeconds());
		assertEquals("IMG URL", sut.getImageURL());
	}

	@Test
	void testForSetters() {
		Album sut = new Album("Title", "Artist", 12, 200, "IMG URL");
		sut.setTitle("New Title");
		sut.setArtist("New Artist");
		sut.setSongCount(99);
		sut.setLengthInSeconds(99);
		sut.setImageURL("New IMG URL");
		assertEquals("New Title", sut.getTitle());
		assertEquals("New Artist", sut.getArtist());
		assertEquals(99, sut.getSongCount());
		assertEquals(99, sut.getLengthInSeconds());
		assertEquals("New IMG URL", sut.getImageURL());
	}

}
