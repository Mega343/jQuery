package com.nixsolutions.web.controller.rest.exception;

import java.io.Serializable;

public class UserControllerException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    public UserControllerException() {
        super();
    }

    public UserControllerException(String msg) {
        super(msg);
    }

    public UserControllerException(String msg, Exception e) {
        super(msg, e);
    }
}
