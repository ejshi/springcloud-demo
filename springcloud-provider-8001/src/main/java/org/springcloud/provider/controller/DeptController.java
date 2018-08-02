package org.springcloud.provider.controller;

import java.util.List;

import org.springcloud.api.model.Dept;
import org.springcloud.provider.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return deptService.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return deptService.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list() {
		return deptService.list();
	}
	
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery() {
		//client.getServices()的意思是获取eureka里面有多少个微服务
        //那么我们如果只有一个微服务是部门，后续我们在工作中可能会有越来越多的微服务
        //那么List查出来的就会有很多的微服务，然后进行遍历然后打印出来
		List<String> list = discoveryClient.getServices();
		
        System.out.println("**********" + list);
        
        //client.getInstances()的意思就是在那么多的微服务里面，你指定只找哪一个微服务
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER");
        for (ServiceInstance element : instances) {
        	 System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                     + element.getUri());
		}
		return discoveryClient;
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(){
		
		return "hello spring clould";
	}
	
   /**
	* 本地服务实例的信息
	* @return
	*/
	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {
		ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
		return localServiceInstance;
	}
	
}
