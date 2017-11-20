package com.careydevelopment.masculex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.careydevelopment.masculex.jpa.entity.Post;
import com.careydevelopment.masculex.jpa.repository.PostRepository;

@Controller
public class IndexController {
	
	@Autowired
	PostRepository postRepository;

    @RequestMapping(value = "/{context}", method=RequestMethod.GET)
    public String youtubeDemo(@PathVariable String context, Model model) {
    	
    	Post p = postRepository.fetchBySlug("the_20_best_5.11_men's_polo_shirts");
    	System.err.println("The id is " + p.getId());
    	
        return context + "/index";
    }
	
}
