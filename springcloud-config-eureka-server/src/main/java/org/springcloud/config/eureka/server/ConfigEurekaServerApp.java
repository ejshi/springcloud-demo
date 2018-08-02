package org.springcloud.config.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class ConfigEurekaServerApp {

    public static void main( String[] args ){
    	SpringApplication.run(ConfigEurekaServerApp.class, args);
        System.out.println( "=============== ConfigEurekaServerApp start success =============" );
    }
}
