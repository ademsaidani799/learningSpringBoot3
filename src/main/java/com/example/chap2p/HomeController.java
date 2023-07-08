package com.example.chap2p;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private final VideoService vs;
    public HomeController(VideoService vs){
        this.vs= vs;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("videos", vs.getVideos());
        return "index";
    }


    //this will accept the data sent from the html form
    @PostMapping("/new-video")
    public String newVideo(@ModelAttribute Video newVideo){
        vs.create(newVideo);
        return "redirect:/";
    }

    @GetMapping("/react")
    public String react(){
        return "react";
    }


}
