package org.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //开启feign,备注 @EnableFeignClients与@ComponentScan有冲突，需要将bean包放在和mian启动类同级
public class DeptConsumerApp { 
	
    public static void main( String[] args ){
    	SpringApplication.run(DeptConsumerApp.class, args);
        System.out.println("============ DeptConsumerApp start success ============");
    }
}
