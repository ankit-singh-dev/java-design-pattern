package org.example.structuraldesignpattern;

/*
https://refactoring.guru/design-patterns/proxy
https://www.digitalocean.com/community/tutorials/proxy-design-pattern
https://www.geeksforgeeks.org/proxy-design-pattern/
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
You-Tube model class
 */
class YouTubeVideoModel {
    String url;
    boolean is18Plus;

    public YouTubeVideoModel(String url, boolean is18Plus) {
        this.url = url;
        this.is18Plus = is18Plus;
    }
}

/*
Interface that provide base layer for both proxy and concrete class
 */
interface YouTubeVideoInterface {
    Map<String, YouTubeVideoModel> getAllYouTubeVideos();

    YouTubeVideoModel getYouTubeVideo(String name);
}

/*
Normal Access Class
 */
class YoutubeVideosImpl implements YouTubeVideoInterface {

    Map<String, YouTubeVideoModel> allVideos;

    @Override
    public Map<String, YouTubeVideoModel> getAllYouTubeVideos() {
        allVideos = new HashMap<>();
        allVideos.put("java-design-pattern", new YouTubeVideoModel("abc.html", false));
        allVideos.put("python-basic", new YouTubeVideoModel("def.html", true));
        allVideos.put("spring-tutorial", new YouTubeVideoModel("mno.html", true));
        allVideos.put("Hibernate-basics", new YouTubeVideoModel("xyz.html", false));
        return allVideos;
    }

    @Override
    public YouTubeVideoModel getYouTubeVideo(String name) {
        if (Objects.nonNull(allVideos) && !allVideos.isEmpty()) {
            return allVideos.get(name);
        }
        return null;
    }
}

/*
Proxy Class
 */

class YoutubeVideosImplProxy implements YouTubeVideoInterface {

    private final YoutubeVideosImpl youtubeVideos;

    public YoutubeVideosImplProxy() {
        youtubeVideos = new YoutubeVideosImpl();
        getAllYouTubeVideos();
    }

    @Override
    public Map<String, YouTubeVideoModel> getAllYouTubeVideos() {
        return youtubeVideos.getAllYouTubeVideos();
    }

    @Override
    public YouTubeVideoModel getYouTubeVideo(String name) {
        YouTubeVideoModel response = youtubeVideos.getYouTubeVideo(name);
        if (Objects.nonNull(response)) {
            if (response.is18Plus) {
                System.out.println(name + " is Age restricted");
                System.out.println("Please login to your account to view the video");
                return null;
            } else {
                System.out.println("Enjoy your video " + name);
                return response;
            }
        }
        System.out.println("Request youtube video doesn't exist");
        return null;
    }
}


public class ProxyDesignPattern {

    public static void main(String[] args) {
        YouTubeVideoInterface accessVideo = new YoutubeVideosImplProxy();
        accessVideo.getYouTubeVideo("java-design-pattern");
        accessVideo.getYouTubeVideo("python-basic");
    }
}
