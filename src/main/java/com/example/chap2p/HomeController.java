package com.example.chap2p;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    record Video(String name){}

    List<Video> videos = List.of(
            new Video("Need help with spring boot 3 app?"),
            new Video("Dont't do this to your own code"),
            new Video("Secrets to fix broken code!"));

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("videos", videos);
        return "index";
    }
}
