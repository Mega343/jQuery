package com.nixsolutions.web;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/rest")
public class RestApplication extends ResourceConfig {

    public RestApplication() {
        packages("com.nixsolutions.web.controller");
    }
}
