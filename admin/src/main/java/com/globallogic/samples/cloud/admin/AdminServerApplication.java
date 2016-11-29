package com.globallogic.samples.cloud.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableAutoConfiguration
@EnableEurekaClient
@EnableHystrixDashboard
public class AdminServerApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(AdminServerApplication.class, args);
    }
}
