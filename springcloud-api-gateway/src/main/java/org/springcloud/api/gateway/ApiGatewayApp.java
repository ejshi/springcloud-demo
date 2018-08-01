package org.springcloud.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * api网关配置
 * @author shijun03
 */
@SpringBootApplication
public class ApiGatewayApp { 

    public static void main( String[] args ){
    
        SpringApplication.run(ApiGatewayApp.class, args);
        
        System.out.println("============= ApiGatewayApp start success ===============");
    }
}
