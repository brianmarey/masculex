package com.careydevelopment.masculex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {

    @RequestMapping(value = "/{context}/post", method=RequestMethod.GET)
    public String youtubeDemo(@PathVariable String context, Model model) {
        return context + "/post";
    }
	
}
