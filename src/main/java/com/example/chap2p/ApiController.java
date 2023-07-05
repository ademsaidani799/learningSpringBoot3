package com.example.chap2p;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    private final VideoService videoService;

    //by the DI in the next contructor ~we get the same instance of previous VideoService
    public ApiController(VideoService videoService) {
        this.videoService = videoService;
    }
    @GetMapping("/api/videos")
    public List<Video> all() {
        return videoService.getVideos();
    }

    @PostMapping("/api/videos")
    public Video newVideo(@RequestBody Video v){
        return videoService.create(v);
    }
}