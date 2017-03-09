package com.nixsolutions.web.controller.rest;

import com.nixsolutions.dto.UserDTO;
import com.nixsolutions.model.Document;
import com.nixsolutions.model.DocumentType;
import com.nixsolutions.model.Role;
import com.nixsolutions.model.User;
import com.nixsolutions.service.DocumentTypeService;
import com.nixsolutions.service.RoleService;
import com.nixsolutions.service.UserService;
import com.nixsolutions.web.controller.rest.exception.UserControllerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DocumentTypeService documentTypeService;


    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GET
    @Path("{user_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("user_id") Long userID) throws UserControllerException {
        User user = userService.getUser(userID);
        if(user == null) {
            throw new UserControllerException("User with id: " + userID + " absent in database.");
        }
        return user;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String saveUser(UserDTO userDTO) {
        User user = UserDTO.getUser(userDTO);
        setRole(userDTO, user);
        userService.add(user);
        return user.getUserID().toString();
    }


    @PUT
    @Path("{user_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateUser(UserDTO userDTO) throws UserControllerException {
        User user;
        if(userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            user = UserDTO.getUser(userDTO);
            setRole(userDTO, user);
            setDocument(userDTO, user);
            userService.edit(user);
        } else {
            throw new UserControllerException("Passwords do not match.");
        }
        return user.getUserID().toString();
    }

    @DELETE
    @Path("{user_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteUser(@PathParam("user_id") Long userID) throws UserControllerException {
        try {
            userService.delete(userID);
        } catch (RuntimeException e) {
            throw new UserControllerException("Cannot delete user who have orders.");
        }
        return userID.toString();
    }



    private void setRole(UserDTO userDTO, User user) {
        Role role;
        if(userDTO.getUserRole() != null) {
            role = roleService.getRoleByName(userDTO.getUserRole());
        } else {
            role = roleService.getRoleByName("Guest");
        }
        user.setRole(role);
    }

    private void setDocument(UserDTO userDTO, User user) {
        DocumentType documentType = documentTypeService.findDocumentTypeByName(userDTO.getDocumentType());
        user.setDocument(new Document(userDTO.getDocumentID(), documentType, userDTO.getSeries(), userDTO.getNumber(),
                userDTO.getIssuedBy(), userDTO.getDateOfIssue()));
    }
}