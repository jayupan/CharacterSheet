/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.CharacterSheet.controller;

import com.mthree.CharacterSheet.dao.ClassDao;
import com.mthree.CharacterSheet.dto.APIReference;
import com.mthree.CharacterSheet.dto.CharacterClass;
import com.mthree.CharacterSheet.dto.Greeting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Josef
 */
@RestController
public class CreateController {
    
    @Autowired
    JdbcTemplate jdbc;
    
    @Autowired
    ClassDao classDao;

    @RequestMapping("create")
    public ModelAndView create (RestTemplate restTemplate) {
        ModelAndView modelAndView = new ModelAndView();
        List<APIReference> classes = new ArrayList<>();
        CharacterClass cla = restTemplate.getForObject("https://www.dnd5eapi.co/api/classes", CharacterClass.class);
        
        //for(int i = 0; i < 12; i++)
        //{
           // System.out.println(cla.getResults()[i].getName());
        //}
        Collections.addAll(classes, cla.getResults());
        modelAndView.addObject("classes", classes);
        modelAndView.setViewName("create");
        return modelAndView;
    }
    
    @PostMapping("/getClass")
    public ModelAndView test (RestTemplate restTemplate, HttpServletRequest request)
    {
        ModelAndView modelAndView = new ModelAndView();
        String name = request.getParameter("class");
        System.out.println(name);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
