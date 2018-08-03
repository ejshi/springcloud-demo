package org.springcloud.client.zipkin.controller;

import java.util.List;

import org.springcloud.api.model.Dept;
import org.springcloud.client.zipkin.constant.UrlConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ZinkinDemoController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/demo/zipkin")
	public String get(){
		return "zipkin";
	}
	
	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(UrlConstant.REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {

		return restTemplate.getForObject(UrlConstant.REST_URL_PREFIX + "/dept/list", List.class);
	}
	
	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery() {
		
		return restTemplate.getForObject(UrlConstant.REST_URL_PREFIX + "/dept/discovery", Object.class);
	}
}
