package com.nixsolutions.web.controller;

import com.nixsolutions.model.User;
import com.nixsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getMainPage(Model model) {
        org.springframework.security.core.userdetails.User loggedUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.searchByEmail(loggedUser.getUsername());
        if ("Admin".equals(user.getRole().getUserRole()) || "Librarian".equals(user.getRole().getUserRole())) {
            return "adminMain";
        } else
            return "main";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage() {
        return "main";
    }
}
