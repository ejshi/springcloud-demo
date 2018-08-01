package org.springcloud.consumer.controller;

import java.util.List;

import org.springcloud.api.model.Dept;
import org.springcloud.consumer.constant.UrlConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DeptController {

//	private static final String REST_URL_PREFIX = "http://localhost:8001";
	//从Eureka上面有一个叫MICROSERVICECLOUD-DEPT微服务名字，按名字访问的微服务
//	private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER";

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(UrlConstant.REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
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
