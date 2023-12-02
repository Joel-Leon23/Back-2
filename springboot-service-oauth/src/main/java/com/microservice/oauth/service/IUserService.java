package com.microservice.oauth.service;

import com.microservice.commons.users.entity.User;

public interface IUserService {

	public User findByUsername(String username);
}
