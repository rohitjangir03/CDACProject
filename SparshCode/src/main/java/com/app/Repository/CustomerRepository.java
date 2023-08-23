package com.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public Optional<Customer> findByEmail(String email);

	/*	public List<Customer> findByName(String name);

	public Customer findByEmailAndPassword(String email, String name);

	public List<Customer> findByActiveTrue();

	public List<Customer> findByAboutIsNotNull();

	public List<Customer> findByNameStartingWith(String prifix);

	public List<Customer> findByNameContaining(String infix);

	public List<Customer> findByNameLike(String like);

	// Creating Query Method
	@Query("select u from User u")
	public List<Customer> getAllUser();*/
}
