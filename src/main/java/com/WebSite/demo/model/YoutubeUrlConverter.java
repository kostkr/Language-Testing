package com.WebSite.demo.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class YoutubeUrlConverter {
    public static String generateEmbeddedUrl(String youtubeUrl) {
        String videoId = extractVideoId(youtubeUrl);

        if (videoId != null && !videoId.isEmpty()) {
            String embeddedUrl = "https://www.youtube.com/embed/" + videoId;
            return embeddedUrl;
        } else {
            // Handle invalid YouTube URL
            return null;
        }
    }

    private static String extractVideoId(String youtubeUrl) {
        String pattern = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed\042%2F|youtu.be%2F|%2Fv%2F|watch\\?v=|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed\\?video_id=|embed\\/videos\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|%2Fvideos%2F|%2Fv%2F|e\\/|%2Fv%2F)[^#\\&\\?\\n]*";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(youtubeUrl);

        if (matcher.find()) {
            return matcher.group();
        }

        return null;
    }
}
