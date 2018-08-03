package org.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeptProviderApp {

    public static void main( String[] args ){
    	SpringApplication.run(DeptProviderApp.class, args);
    	System.out.println("======== DeptProviderApp start success =======");
    }
}
