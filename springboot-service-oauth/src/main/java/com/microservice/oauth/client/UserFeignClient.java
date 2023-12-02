package com.microservice.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice.commons.users.entity.User;

@FeignClient("service-users")
public interface UserFeignClient {

	@GetMapping("/users/search/buscar-username")
	public User findByUsername(@RequestParam String username);
	
}
