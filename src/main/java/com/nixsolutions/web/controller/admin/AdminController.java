package com.nixsolutions.web.controller.admin;

import com.nixsolutions.model.*;
import com.nixsolutions.dto.UserDTO;
import com.nixsolutions.service.DocumentTypeService;
import com.nixsolutions.service.RoleService;
import com.nixsolutions.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    private static final Logger LOG = LogManager.getLogger(AdminController.class.getName());

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DocumentTypeService documentTypeService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, @RequestParam(value = "error", required = false) String error) {
        try {
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
            if (error != null) {
                model.addAttribute("error", error);
            }
        } catch (Exception e) {
            LOG.catching(e);
            model.addAttribute("error", e.getMessage());
            return "admin";
        }
        return "admin";
    }

    @RequestMapping(value = "/delete")
    public String deleteUser(@RequestParam("user_id") String userID, Model model) {
        try {
            userService.delete(Long.parseLong(userID));
            return "redirect:/admin";
        } catch (Exception e) {
            LOG.catching(e);
            model.addAttribute("error", "Can not delete user who has orders.");
            return "redirect:/admin";
        }
    }


    @RequestMapping(value = "/update_user", method = RequestMethod.GET)
    public ModelAndView viewUserUpdateForm(@RequestParam("user_id") String userID) {
        try{
            User user = userService.getUser(Long.parseLong(userID));
            UserDTO userDTO = UserDTO.getUserDTO(user);
            return new ModelAndView("updateUser", "user", userDTO);
        } catch (Exception e) {
            LOG.catching(e);
            throw LOG.throwing(new RuntimeException(e));
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user")UserDTO userDTO, Model model) {
        org.springframework.security.core.userdetails.User loggedUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            if (!isAdminTryChangeRoleHimself(loggedUser.getUsername(), userDTO)) {
                try {
                    User user = UserDTO.getUser(userDTO);
                    Role role = roleService.getRoleByName(userDTO.getUserRole());
                    DocumentType documentType = documentTypeService.findDocumentTypeByName(userDTO.getDocumentType());
                    user.setRole(role);
                    Document document = user.getDocument();
                    document.setDocumentType(documentType);
                    user.setDocument(document);
                    userService.edit(user);
                    return "redirect:/admin";
                } catch (Exception e) {
                    LOG.catching(e);
                    model.addAttribute("error", e.getMessage());
                    return "redirect:/admin";
                }
            } else {
                model.addAttribute("error", "Error. Cannot change admin role.");
                model.addAttribute("user", userDTO);
                return "updateUser";
            }
        } else {
            model.addAttribute("user", userDTO);
            model.addAttribute("error", "Passwords do not match.");
            return "updateUser";
        }
    }

    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public String viewAddress(@RequestParam("user_id") String userID, Model model) {
        Address address;
        User user;
        try{
            user = userService.getUser(Long.parseLong(userID));
            address = user.getAddress();
            model.addAttribute("address", address);
            model.addAttribute("user", user);
            return "address";
        } catch (Exception e){
            LOG.catching(e);
            model.addAttribute("error", e.getMessage());
            return "redirect:/admin";
        }
    }

    @RequestMapping(value = "/document", method = RequestMethod.GET)
    public String viewDocument(@RequestParam("user_id") String userID, Model model) {
        Document document;
        DocumentType documentType;
        User user;
        try{
            user = userService.getUser(Long.parseLong(userID));
            document = user.getDocument();
            documentType = document.getDocumentType();
            model.addAttribute("document", document);
            model.addAttribute("docType", documentType);
            model.addAttribute("user", user);
            return "document";
        } catch (Exception e){
            LOG.catching(e);
            model.addAttribute("error", e.getMessage());
            return "redirect:/admin";
        }
    }

    private boolean isAdminTryChangeRoleHimself(String email, UserDTO updatedUser) {
        User admin = userService.searchByEmail(email);
        if(admin.getUserID().equals(updatedUser.getUserID())) {
            String previousRole = admin.getRole().getUserRole();
            String updatedRole = updatedUser.getUserRole();
            if (previousRole.equals("Admin") && !updatedRole.equals("Admin")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
