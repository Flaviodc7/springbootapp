package com.flaviocoscarella.demo.config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@ApplicationPath("/")
@Component
public class jerseyConfig extends ResourceConfig {
    public jerseyConfig(){
        this.packages("com.flaviocoscarella.demo.controllers");
    }
}
