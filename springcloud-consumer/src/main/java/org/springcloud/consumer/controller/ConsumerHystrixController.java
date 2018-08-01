package org.springcloud.consumer.controller;

import org.springcloud.api.model.Dept;
import org.springcloud.consumer.service.ConsumerHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerHystrixController {
	
	@Autowired
	private ConsumerHystrixService consumerHystrixService;
	
	@GetMapping(path = "/hystrix/dept/get/{id}")
	public Dept get(@PathVariable Long id){
		return consumerHystrixService.get(id);
	}
}
