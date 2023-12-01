package com.microservice.users.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.microservice.users.entities.User;


@RepositoryRestResource(path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
	public User findByUsername(String username);
	
	
	public User findByUsernameAndEmail(String username, String email);
	
	@Query(value = "select u from User u where u.username = ?1")
	public User obtenerPorUsername(String username);
	
	@Query(value = "select u from User u where u.username = ?1 and u.email = ?2")
	public User obtenerPorUsernameYEmail(String username, String email);
}
