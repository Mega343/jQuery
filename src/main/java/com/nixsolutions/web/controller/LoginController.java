package com.nixsolutions.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "msg", required = false) String msg) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password!");
        }
        if (msg != null) {
            model.addObject("msg", msg);
        }
        model.setViewName("index");
        return model;
    }
}
