package com.example.chap2p;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {
    List<Video> videos = List.of(
            new Video("Need help with spring boot 3 app?"),
            new Video("Dont't do this to your own code"),
            new Video("Secrets to fix broken code!"));

    List<Video> getVideos(){
        return this.videos;
    }

    public Video create(Video newVideo) {
        List<Video> extend = new ArrayList<>(videos);
        extend.add(newVideo);
        this.videos = List.copyOf(extend);
        return newVideo;
    }
}
