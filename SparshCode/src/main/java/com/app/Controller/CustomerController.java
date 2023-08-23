package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.CustomerDto;
import com.app.Service.CustomerService;

@RestController
@RequestMapping("/cust")
public class CustomerController {

	@Autowired
	private CustomerService custService;
	 
	@PostMapping("/create")
	public ResponseEntity<CustomerDto> createUser(@RequestBody CustomerDto custDto){
		CustomerDto cd= custService.create(custDto);
		return new ResponseEntity<CustomerDto>(cd,HttpStatus.CREATED);
	}
	
	@GetMapping("view/{custId}")
	public ResponseEntity<CustomerDto> findbyId(@PathVariable int custId){
		CustomerDto cid = custService.getByUserId(custId);
		return new ResponseEntity<CustomerDto>(cid,HttpStatus.FOUND);
	}
	
	@DeleteMapping("del/{custid}")
	public void delteCust(@PathVariable  int custid){
		custService.delete(custid);
	}
	
	@GetMapping("view")
	public ResponseEntity<List<CustomerDto>> findAllCust(){
		List<CustomerDto> findAll = custService.getAll();
		return new ResponseEntity<List<CustomerDto>>(findAll,HttpStatus.FOUND);
	}
	
}
