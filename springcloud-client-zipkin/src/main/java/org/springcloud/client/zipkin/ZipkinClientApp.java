package org.springcloud.client.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZipkinClientApp {

    public static void main( String[] args ){
    	SpringApplication.run(ZipkinClientApp.class, args);
        System.out.println( "======== ZipkinClientApp start success ========" );
    }
}
