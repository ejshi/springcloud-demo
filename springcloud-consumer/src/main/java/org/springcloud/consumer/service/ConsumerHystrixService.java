package org.springcloud.consumer.service;

import org.springcloud.api.model.Dept;
import org.springcloud.consumer.constant.UrlConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 使用Hystrix熔断策略，调用服务由Controller端通过调用RestTemplate --> 改为 --> Controller -->调用service --> service调用resetTemplate实现 
 * @author shijun03
 *
 */
@Service
public class ConsumerHystrixService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="errorMsg")
	public Dept get(Long id){
		return restTemplate.getForObject(UrlConstant.REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}
	
	public Dept errorMsg(Long id){
		return new Dept("服务调用失败，数据不存在");
	}
}
