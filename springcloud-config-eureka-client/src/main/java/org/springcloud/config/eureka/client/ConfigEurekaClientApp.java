package org.springcloud.config.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 更新远程配置中心，配置信息：
 * 1、management.security.enabled=false 关闭权限校验
 * 2、配置修改提交git
 * 3.http://localhost:5002/refresh 需要进行post方式进行请求
 *
 */
@SpringBootApplication
public class ConfigEurekaClientApp {
    public static void main( String[] args ){
    	SpringApplication.run(ConfigEurekaClientApp.class, args);
        System.out.println( "======== ConfigEurekaClientApp start success =======" );
    }
}
