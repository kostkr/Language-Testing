package com.WebSite.demo;

import com.WebSite.demo.model.YoutubeUrlConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class YoutubeUrlConverterTest {

    private YoutubeUrlConverter youtubeUrlConverter;

    @BeforeEach
    public void setUp() {
        youtubeUrlConverter = new YoutubeUrlConverter();
    }

    @Test
    public void testGenerateEmbeddedUrl() {
        String youtubeUrl1 = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
        String youtubeUrl2 = "https://youtu.be/dQw4w9WgXcQ";
        String youtubeUrl3 = "https://www.youtube.com/embed/dQw4w9WgXcQ";
        String youtubeUrl4 = "https://www.youtube.com/v/dQw4w9WgXcQ";
        String invalidUrl = "https://www.notyoutube.com/watch?v=dQw4w9WgXcQ";

        assertThat(youtubeUrlConverter.generateEmbeddedUrl(youtubeUrl1))
                .isEqualTo("https://www.youtube.com/embed/dQw4w9WgXcQ");
        assertThat(youtubeUrlConverter.generateEmbeddedUrl(youtubeUrl2))
                .isEqualTo("https://www.youtube.com/embed/dQw4w9WgXcQ");
        assertThat(youtubeUrlConverter.generateEmbeddedUrl(youtubeUrl3))
                .isEqualTo("https://www.youtube.com/embed/dQw4w9WgXcQ");
        assertThat(youtubeUrlConverter.generateEmbeddedUrl(youtubeUrl4))
                .isEqualTo("https://www.youtube.com/embed/dQw4w9WgXcQ");
        assertThat(youtubeUrlConverter.generateEmbeddedUrl("null")).isEqualTo("");
    }
}
