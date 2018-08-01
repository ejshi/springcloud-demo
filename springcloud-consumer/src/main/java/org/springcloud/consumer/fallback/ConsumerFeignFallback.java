package org.springcloud.consumer.fallback;

import org.springcloud.api.model.Dept;
import org.springcloud.consumer.service.ConsumerFeignService;
import org.springframework.stereotype.Component;

@Component
public class ConsumerFeignFallback implements ConsumerFeignService{

	@Override
	public String hello() {
		return "正常请求失败，降级处理";
	}

	@Override
	public Dept get(Long id) {
		return new Dept("我是降级消息");
	}

	@Override
	public boolean add(Dept dept) {
		System.out.println("=======添加失败======");
		return false;
	}

}
