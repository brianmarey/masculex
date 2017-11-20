package com.careydevelopment.masculex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {

    @RequestMapping(value = "/post", method=RequestMethod.GET)
    public String youtubeDemo(Model model) {
        return "post";
    }
	
}
