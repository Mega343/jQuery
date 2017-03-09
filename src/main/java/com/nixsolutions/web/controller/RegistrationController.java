package com.nixsolutions.web.controller;

import com.nixsolutions.dto.UserDTO;
import com.nixsolutions.model.Role;
import com.nixsolutions.model.User;
import com.nixsolutions.service.RoleService;
import com.nixsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add_user", method = RequestMethod.GET)
    public String viewAddFrom() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") UserDTO user, Model model) {
        if(user.getPassword().equals(user.getConfirmPassword())) {
            if (user.getFirstName().length() == 0 || user.getLastName().length() == 0 || user.getEmail().length() == 0
                    || user.getPhoneNumber().length() == 0 || user.getPassword().length() == 0) {
                model.addAttribute("error", "Error. Fill in all the fields!");
                return "registration";
            } else {
                User userForRegistration = UserDTO.getUser(user);
                userForRegistration.setKarma(0);
                Role role = roleService.getRoleByName("Guest");
                userForRegistration.setRole(role);
                try {
                    userService.add(userForRegistration);
                    model.addAttribute("msg", "You have successfully registered.");
                    return "index";
                } catch (Exception e) {
                    model.addAttribute("error", "Error. User with that email or phone number already registered!" + " " + e.getMessage());
                    return "registration";
                }
            }
        } else {
            model.addAttribute("error", "Passwords do not match");
            return "registration";
        }
    }
}
