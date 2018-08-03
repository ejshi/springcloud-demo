package org.springcloud.server.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/**
 * 开启服务调用链路跟踪
 * @author shijun03
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinApp {  
    public static void main( String[] args ){
    	SpringApplication.run(ZipkinApp.class, args);
        System.out.println( "========== ZipkinApp start success =========" );
    }
}
