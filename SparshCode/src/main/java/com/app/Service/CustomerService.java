package com.app.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.CustomException.customException;
import com.app.DTO.CustomerDto;
import com.app.Model.Customer;
import com.app.Repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository custRepo;
//	@Autowired
//	RoleRepository roleRepository;
//	@Autowired
	//private PasswordEncoder passwordEncoder;

	
	public CustomerDto create(CustomerDto custDto) {
		  Customer cust=this.toEntity(custDto);
		       // String passEncode = this.passwordEncoder.encode(cust.getPassword());
		    //    cust.setPassword(passEncode);
		  Customer userCreate=this.custRepo.save(cust);
		return this.toDto(userCreate);
	}

	public CustomerDto update(CustomerDto t, int custId) {
		Customer u=custRepo.findById(custId).orElseThrow(()->new customException("Customer not found by this id"));
		u.setPhone(t.getPhone());
		u.setPassword(t.getPassword());
		u.setName(t.getName());
		u.setGender(t.getGender());
		u.setEmail(t.getEmail());
		u.setAddress(t.getAddress());
		Customer updateCust=this.custRepo.save(u);
		return this.toDto(updateCust);
	}


	public void delete(int custId) {
		Customer u=custRepo.findById(custId).orElseThrow(() ->new customException("Customer not Found"));
		        custRepo.delete(u);
	
	}


	public List<CustomerDto> getAll() {
	        List<Customer> custAll=custRepo.findAll();	
		               List<CustomerDto> allUserDto=custAll.stream().map(c -> this.toDto(c)).collect(Collectors.toList());
		return allUserDto;
	}


	public CustomerDto getByUserId(int userId) {
				Customer findcust=custRepo.findById(userId).orElseThrow(() -> new customException("User Not Found"+userId));
		          
				return this.toDto(findcust); 
	}


	public CustomerDto getByEmailId(String emailId) {
		       Customer findemail=custRepo.findByEmail(emailId).orElseThrow(() -> new customException("User Email Is is Not Exit"+emailId));
		return this.toDto(findemail);
	}
	
	@Autowired
	private ModelMapper mapper;
	
	public CustomerDto toDto(Customer u) {
//		UserDto dto=new UserDto();
//		dto.setUserId(u.getUserId());
//		dto.setName(u.getName());
//		dto.setEmail(u.getEmail());
//		dto.setPassword(u.getPassword());
//		dto.setAbout(u.getAbout());
//		dto.setAddress(u.getAddress());
//		dto.setGender(u.getGender());
//		dto.setDate(u.getDate());
//		dto.setPhone(u.getPhone());
//		dto.setActive(u.isActive());
		//dto.setRoles(u.getRoles());
		//return dto;
		
		return mapper.map(u,CustomerDto.class);
	}
	
public Customer toEntity(CustomerDto dto) {
//	User  u=new User();
//	u.setUserId(dto.getUserId());
//	u.setPhone(dto.getPhone());
//	u.setPassword(dto.getPassword());
//	u.setName(dto.getName());
//	u.setGender(dto.getGender());
//	u.setEmail(dto.getEmail());
//	u.setDate(dto.getDate());
//	u.setAddress(dto.getAddress());
//	u.setActive(dto.isActive());
//	u.setAbout(dto.getAbout());
//	//u.setRoles(u.getRoles());
//	return u;
	return mapper.map(dto,Customer.class);
}
}
