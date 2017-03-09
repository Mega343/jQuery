package com.nixsolutions.web.controller.admin;

import com.nixsolutions.model.Role;
import com.nixsolutions.model.User;
import com.nixsolutions.service.RoleService;
import com.nixsolutions.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AwaitingConfirmationUserController {

    private static final Logger LOG = LogManager.getLogger(AwaitingConfirmationUserController.class.getName());

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/awaiting_confirmation", method = RequestMethod.GET)
    public String viewUsersAwaitingConfirmation(Model model) {
        try {
            List<User> users = userService.getAllUnconfirmedUsers();
            model.addAttribute("users", users);
            return "awaitingConfirmation";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "There are no users awaiting confirmation.");
            return "awaitingConfirmation";
        } catch (Exception e) {
            LOG.catching(e);
            throw LOG.throwing(new RuntimeException(e));
        }
    }

    @RequestMapping(value = "/awaiting_confirmation", method = RequestMethod.POST)
    public String confirmUser(@ModelAttribute("user_id") Long userID) {
        try {
            Role role = roleService.getRoleByName("Reader");
            User user = userService.getUser(userID);
            user.setRole(role);
            userService.edit(user);
            return "redirect:/awaiting_confirmation";
        } catch (Exception e) {
            LOG.catching(e);
            throw LOG.throwing(new RuntimeException(e));
        }
    }

}
