package com.nixsolutions.web.controller.rest.handler;

import com.nixsolutions.web.controller.rest.exception.UserControllerException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserApplicationExceptionHandler implements ExceptionMapper<UserControllerException> {

    @Override
    public Response toResponse(UserControllerException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
}
