package org.springcloud.config.eureka.server.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

/**
 * spingcloud相关配置开启
 * @author shijun03
 */
@Configuration
@EnableDiscoveryClient
@EnableConfigServer
public class SpringcloudConfig {

}
