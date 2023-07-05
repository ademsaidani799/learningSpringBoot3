package com.example.chap2p;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
