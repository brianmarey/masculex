package com.careydevelopment.masculex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.careydevelopment.masculex.jpa.entity.Context;
import com.careydevelopment.masculex.jpa.entity.Post;
import com.careydevelopment.masculex.jpa.repository.ContextRepository;
import com.careydevelopment.masculex.jpa.repository.PostRepository;


@Controller
public class AllPostsController {
	
	@Autowired
	ContextRepository contextRepository;

	@Autowired
	PostRepository postRepository;
	
    @RequestMapping(value = "/{contextName}/allPosts", method=RequestMethod.GET)
    public String blog(@PathVariable String contextName, Model model) {
    	
    	Context context = contextRepository.fetchByName(contextName);
    	
    	if (context == null) {
    		return "404";
    	} else {
        	model.addAttribute("webContext", context);      
        	List<Post> allPosts = postRepository.findAllPosts(context.getId());            	
        	model.addAttribute("posts", allPosts);
        	        	
        	return "allPosts";
    	}      
    }    

}
