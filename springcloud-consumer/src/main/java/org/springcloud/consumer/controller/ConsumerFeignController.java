package org.springcloud.consumer.controller;

import org.springcloud.api.model.Dept;
import org.springcloud.consumer.service.ConsumerFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过feign进行声明式服务调用
 * @author shijun03
 */
@RestController
public class ConsumerFeignController {

	@Autowired
	private ConsumerFeignService consumerFeignService;
	
	@RequestMapping(value = "/feign/hello")
	public String hello() {
		return consumerFeignService.hello();
	}
	
	@GetMapping(path = "/feign/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id){
		return consumerFeignService.get(id);
	}
	
	@RequestMapping(value = "/feign/dept/add")
	public boolean add(Dept dept) {
		return consumerFeignService.add(dept);
	}
}
