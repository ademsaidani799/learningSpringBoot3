package com.example.chap2p;

import com.example.chap2p.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository
        <VideoEntity, Long> {
    List<VideoEntity> findByName (String name);

}