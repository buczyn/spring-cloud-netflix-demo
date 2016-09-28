package com.globallogic.samples.cloud.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableAutoConfiguration
@EnableEurekaServer
public class RegistryServerApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(RegistryServerApplication.class, args);
    }
}
