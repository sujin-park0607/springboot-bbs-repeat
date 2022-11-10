package com.mustache.bbsrepeat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class MustacheController {

    @GetMapping(value = "/hi")
    public String mustacheCon(Model model){
        model.addAttribute("username", "rok");
        return "greetings";
    }

    @GetMapping(value="/hi/{id}")
    public String mustachCon(@PathVariable String id, Model model){
        model.addAttribute("username", "rok");
        model.addAttribute("id",id);
        return "greetings";
    }

}
