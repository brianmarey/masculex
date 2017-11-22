package com.careydevelopment.masculex.controller;

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
public class BlogController {
	
	@Autowired
	ContextRepository contextRepository;

	@Autowired
	PostRepository postRepository;
	
    @RequestMapping(value = "/{contextName}/blog", method=RequestMethod.GET)
    public String blog(@PathVariable String contextName, 
    	@RequestParam(value="pageNum", required=false) String pageNum, Model model) {
    	
    	Context context = contextRepository.fetchByName(contextName);
    	
    	if (context == null) {
    		return "404";
    	} else {
        	model.addAttribute("webContext", context);      
        	
        	int page = getPage(pageNum);
        	Pageable pageable = new PageRequest(page, 20);
        	Page<Post> posts = postRepository.findPosts(pageable);
        	model.addAttribute("posts", posts);
        	
        	setPagination(posts,model,page);
        	
        	return "blog";
    	}      
    }
    
    
    private void setPagination (Page<Post> posts, Model model, int page) {
    	model.addAttribute("isFirst", posts.isFirst());
    	model.addAttribute("isLast", posts.isLast());
    	
    	if (!posts.isLast()) {
    		model.addAttribute("nextPageNum", page+1);
    	}
    	
    	if (!posts.isFirst()) {
    		model.addAttribute("previousPageNum", page-1);
    	}	    	
    }

    
    private int getPage(String pageNum) {
    	int page = 0;
    	
    	if (pageNum != null) {
    		try {
    			page = new Integer(pageNum);
    		} catch (NumberFormatException ne) {
    			ne.printStackTrace();
    			//LOGGER.warn("Page number isn't a number! " +pageNum);
    		}
    	}
    	
    	return page;
    }
}
