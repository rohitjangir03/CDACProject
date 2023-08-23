package com.app.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	@Id
	@Column(name="Role_Id")
   private int roleId;
	@Column(nullable = false)
   private String roleName;
	@ManyToMany(mappedBy = "roles")
	Set<Customer> cust = new HashSet<>();
}
