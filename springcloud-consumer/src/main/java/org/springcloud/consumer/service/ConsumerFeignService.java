package org.springcloud.consumer.service;

import org.springcloud.api.model.Dept;
import org.springcloud.consumer.fallback.ConsumerFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//通过@FeignClient注解指定服务名来绑定服务，这里的服务名字不区分大小写
//然后再通过@RequestMapping来绑定服务下的rest接口
@FeignClient(name="SPRINGCLOUD-PROVIDER",fallback=ConsumerFeignFallback.class)
public interface ConsumerFeignService {

	@RequestMapping(value="/hello" ,method = RequestMethod.GET)
	public String hello();
	
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id);

	@RequestMapping(value = "/dept/add" , method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept);
	
}
