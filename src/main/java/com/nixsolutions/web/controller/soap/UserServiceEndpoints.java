package com.nixsolutions.web.controller.soap;

import com.nixsolutions.dto.UserDTO;
import com.nixsolutions.model.Document;
import com.nixsolutions.model.DocumentType;
import com.nixsolutions.model.Role;
import com.nixsolutions.model.User;
import com.nixsolutions.service.DocumentTypeService;
import com.nixsolutions.service.RoleService;
import com.nixsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.sql.Date;

@Endpoint
public class UserServiceEndpoints {

    private static final String TARGET_NAMESPACE = "http://localhost:8080/soap";

    @Autowired
    private UserService userService;
    @Autowired
    private DocumentTypeService documentTypeService;
    @Autowired
    private RoleService roleService;

    @PayloadRoot(localPart = "createUserRequest", namespace = TARGET_NAMESPACE)
    public
    @ResponsePayload
    CreateUserResponse createUser(@RequestPayload CreateUserRequest request) {

        UserDTO userDTO = new UserDTO();

        userDTO.setFirstName(request.getFirstName());
        userDTO.setLastName(request.getLastName());
        userDTO.setEmail(request.getEmail());
        userDTO.setPassword(request.getPassword());
        userDTO.setPhoneNumber(request.getPhoneNumber());

        User user = UserDTO.getUser(userDTO);
        setRole(userDTO, user);
        userService.add(user);

        CreateUserResponse response = new CreateUserResponse();
        response.setUserID(user.getUserID());
        return response;
    }

    @PayloadRoot(localPart = "updateUserRequest", namespace = TARGET_NAMESPACE)
    public
    @ResponsePayload
    UpdateUserResponse updateUser(@RequestPayload UpdateUserRequest request) {

        UserDTO userDTO = new UserDTO();

        userDTO.setUserID(request.getUserID());
        userDTO.setFirstName(request.getFirstName());
        userDTO.setLastName(request.getLastName());
        userDTO.setEmail(request.getEmail());
        userDTO.setPassword(request.getPassword());
        userDTO.setPhoneNumber(request.getPhoneNumber());
        userDTO.setKarma(request.getKarma());
        userDTO.setUserRole(request.getUserRole());
        userDTO.setAddressID(request.getAddressID());
        userDTO.setHouseNumber(request.getHouseNumber());
        userDTO.setStreetName(request.getStreetName());
        userDTO.setCityName(request.getCityName());
        userDTO.setFlatNumber(request.getFlatNumber());
        userDTO.setDocumentID(request.getDocumentID());
        userDTO.setDocumentType(request.getDocumentType());
        userDTO.setSeries(request.getSeries());
        userDTO.setNumber(request.getNumber());
        userDTO.setIssuedBy(request.getIssuedBy());
        userDTO.setDateOfIssue(Date.valueOf(request.getDateOfIssue()));

        User user = UserDTO.getUser(userDTO);
        setRole(userDTO, user);
        setDocument(userDTO, user);
        userService.edit(user);

        UpdateUserResponse response = new UpdateUserResponse();
        response.setUserID(user.getUserID());
        return response;
    }

    private void setRole(UserDTO userDTO, User user) {
        Role role;
        if (userDTO.getUserRole() != null) {
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