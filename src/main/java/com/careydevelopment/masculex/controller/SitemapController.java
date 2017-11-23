package com.careydevelopment.masculex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.careydevelopment.masculex.jpa.entity.Context;
import com.careydevelopment.masculex.jpa.entity.Post;
import com.careydevelopment.masculex.jpa.repository.ContextRepository;
import com.careydevelopment.masculex.jpa.repository.PostRepository;


@Controller
public class SitemapController {
	
	@Autowired
	ContextRepository contextRepository;

	@Autowired
	PostRepository postRepository;
	
    @RequestMapping(value = "/{contextName}/sitemap", method=RequestMethod.GET, produces = { "application/xml", "text/xml" }, consumes = MediaType.ALL_VALUE)
    public String blog(@PathVariable String contextName, Model model) {
    	
    	Context context = contextRepository.fetchByName(contextName);
    	
    	if (context == null) {
    		return "404";
    	} else {
    		model.addAttribute("webContext", context);
    		
        	List<Post> allPosts = postRepository.findAllPosts();            	
        	model.addAttribute("posts", allPosts);
        	        	
        	return "sitemap";
    	}      
    }    

}
