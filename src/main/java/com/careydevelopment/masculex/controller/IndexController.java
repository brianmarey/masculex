package com.careydevelopment.masculex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.careydevelopment.masculex.jpa.entity.Context;
import com.careydevelopment.masculex.jpa.repository.ContextRepository;

@Controller
public class IndexController {
	
	@Autowired
	ContextRepository contextRepository;

    @RequestMapping(value = "/{contextName}", method=RequestMethod.GET)
    public String index(@PathVariable String contextName, Model model) {
    	
    	Context context = contextRepository.fetchByName(contextName);
    	model.addAttribute("logoUrl", context.getLogoUrl());
    	model.addAttribute("homeUrl", context.getHomeUrl());
    	
    	System.err.println("home url is " + context.getHomeUrl());
    	
        return "index";
    }
	
}
