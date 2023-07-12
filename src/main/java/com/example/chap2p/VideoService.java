package com.example.chap2p;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class VideoService {
    private final VideoRepository repository;

    public VideoService(VideoRepository repository) {
        this.repository = repository;
    }    List<Video> videos = List.of(
            new Video("Need help with spring boot 3 app?"),
            new Video("Dont't do this to your own code"),
            new Video("Secrets to fix broken code!"));

    List<Video> getVideos() {
        return this.videos;
    }

    public Video create(Video newVideo) {
        List<Video> extend = new ArrayList<>(videos);
        extend.add(newVideo);
        this.videos = List.copyOf(extend);
        return newVideo;
    }

    public List<VideoEntity> search(VideoSearch videoSearch) {
        if (StringUtils.hasText(videoSearch.name())
                && StringUtils.hasText(videoSearch.description())) {
            return repository
                    .findByNameContainsOrDescriptionContainsAllIgnoreCase(
                            videoSearch.name(), videoSearch.description());
        }
        if (StringUtils.hasText(videoSearch.name())) {
            return repository.findByNameContainsIgnoreCase(
                    videoSearch.name());
        }
        if (StringUtils.hasText(videoSearch.description())) {
            return repository.findByDescriptionContainsIgnoreCase
                    (videoSearch.description());

        }
        return Collections.emptyList();


    }

    public List<VideoEntity> search(UniversalSearch search) {
        VideoEntity probe = new VideoEntity();
        if (StringUtils.hasText(search.value())) {
            probe.setName(search.value());
            probe.setDescription(search.value());
        }
        Example<VideoEntity> example = Example.of(probe, //
                ExampleMatcher.matchingAny() //
                        .withIgnoreCase() //
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
        return repository.findAll(example);
    }
}