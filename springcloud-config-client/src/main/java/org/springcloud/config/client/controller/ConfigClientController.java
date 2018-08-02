package org.springcloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @RefreshScope 在@Bean上面定义，实时刷新注入的组件，如配置文件信息
 * @author shijun03
 */
@RefreshScope
@RestController
public class ConfigClientController {

	@Value("${from}")
	private String from;
	
	@GetMapping(value = "/from")
	public String getPropertiesFrom(){
		
		return "配置文件中的数据："+from;
	}
}
