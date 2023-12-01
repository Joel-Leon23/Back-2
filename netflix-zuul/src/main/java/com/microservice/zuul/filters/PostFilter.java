package com.microservice.zuul.filters;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.util.Pair;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PostFilter.class);
	
	@Override
	public boolean shouldFilter() {
		// 
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// 
		RequestContext ctx = RequestContext.getCurrentContext();
		List<Pair<String, String>> resHeaders = ctx.getZuulResponseHeaders();
		
		log.info("Logging Post info");
		
		log.info(String.format("ZuulRequest headers in post: %s", ctx.getZuulRequestHeaders()));
		
		log.info(String.format("Res headers: %s", resHeaders.stream().map(h -> h)));
		
		for (Pair<String, String> header : resHeaders) {    		
    		if("Date".equalsIgnoreCase(header.first())) {
    			log.info(String.format("First Header (Date): %s , %s ... Preparing deletion", header.first(), header.second()));
    		}
        }
		
		resHeaders.removeIf(header -> "Date".equalsIgnoreCase(header.first()));
		
		log.info("Headers after date deletion");
		
		for (Pair<String, String> header : resHeaders) {    		
    		if("Date".equalsIgnoreCase(header.first())) {
    			log.info(String.format("First Header (Date): %s : %s ... Preparing deletion", header.first(), header.second()));
    		}
        }
		
		return null;
	}

	@Override
	public String filterType() {
		// 
		return "post";
	}

	@Override
	public int filterOrder() {
		// 
		return 1;
	}

}
