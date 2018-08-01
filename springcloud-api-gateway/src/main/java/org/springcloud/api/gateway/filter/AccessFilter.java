package org.springcloud.api.gateway.filter;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 继承ZuulFilter，并且实现其4个接口
 * 用来进行请求过滤
 * @author shijun03
 */
public class AccessFilter extends ZuulFilter{
	
    Logger logger = LoggerFactory.getLogger(AccessFilter.class);

	/**
	 * 添加统一过滤接口
	 */
	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		String accessToken = request.getParameter("accessToken");
		logger.info("send {} request to {}", request.getMethod() ,request.getRequestURL().toString());
		if(!Optional.ofNullable(accessToken).isPresent()){
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			context.setResponseBody("{\"result\":\"accessToken为空!\"}");
			context.getResponse().setContentType("text/html;charset=UTF-8");
			
			logger.info("请求不合法");
			return null;
		}
		return null;
	}
	/** 
     * shouldFilter 判断该过滤器是否需要被执行
     * 
     * 这里直接返回true，表示该过滤器对所有请求都会生效。
     * 实际运用中我们可以利用该函数指定过滤器的有效范围
     */
	@Override
	public boolean shouldFilter() {
		
		return true;
	}
	/** 
     * filterOrder 返回过滤器的执行顺序,优先级，数字越大，优先级越低
     * 当请求在一个阶段有多个过滤器是，需要根据该方法的返回值来依次执行
     */
	@Override
	public int filterOrder() {
		
		return 0;
	}
	/** 
	 * filterType 返回过滤器类型
     * 他决定了过滤器在请求的哪个生命周期中执行。这里定义为pre，代表会在请求被路由前执行。
     * 
     * pre:请求执行之前filter 
     * route: 处理请求，进行路由 
     * post: 请求处理完成后执行的filter 
     * error:出现错误时执行的filter
     */
	@Override
	public String filterType() {
		
		return "pre";
	}

}
