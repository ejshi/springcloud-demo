package org.springcloud.consumer.config;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@Configuration
//@SpringCloudApplication //@SpringCloudApplication = @EnableDiscoveryClient + @EnableCircuitBreaker
@EnableDiscoveryClient //开启服务发现
@EnableCircuitBreaker //开启断路器
public class SpringCloudConfig {

}
