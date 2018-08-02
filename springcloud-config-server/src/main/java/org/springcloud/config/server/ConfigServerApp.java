package org.springcloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @EnableConfigServer 开启Spring Cloud Config 的服务端功能
 * @author shijun03
 *
 */
@SpringBootApplication
@EnableConfigServer 
public class ConfigServerApp { 
    public static void main( String[] args ){
        SpringApplication.run(ConfigServerApp.class, args);
    	System.out.println( "============ ConfigServerApp start success ===========" );
    }
}
