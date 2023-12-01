package com.microservice.zuul.filters;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PreFilter.class);
	
	@Override
	public boolean shouldFilter() {
		// 
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// 
		RequestContext ctx = RequestContext.getCurrentContext();
		log.info("Start pre filter...");
		log.info(String.format("Zuul addds RequestHeader. Pre headers: ", ctx.getZuulRequestHeaders()));
		ctx.addZuulRequestHeader("prefilter_uuid", UUID.randomUUID().toString());
		
		
		return null;
	}

	@Override
	public String filterType() {
		// 
		return "pre";
	}

	@Override
	public int filterOrder() {
		// 
		return 1;
	}

}
