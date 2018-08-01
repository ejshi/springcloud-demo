package org.springcloud.api.gateway.config;

import org.springcloud.api.gateway.filter.AccessFilter;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @EnableZuulProxy 开启Zuul 的API网关服务功能
 * @author shijun03
 */
@Configuration
@EnableZuulProxy
public class ZuulConfig {

	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}
}
