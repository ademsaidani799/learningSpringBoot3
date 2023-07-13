package com.example.chap2p;

import com.example.chap2p.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepository extends JpaRepository
        <VideoEntity, Long> {

    List<VideoEntity> findByNameContainsIgnoreCase(String partialName);

    List<VideoEntity> findByDescriptionContainsIgnoreCase(String partialDescription);

    List<VideoEntity> findByNameContainsOrDescriptionContainsAllIgnoreCase(String partialName,

                                                                           String partialDescription);

    @Query("select v from VideoEntity v where v.name = ?1")
    List<VideoEntity> findCustomerReport(String name);


}