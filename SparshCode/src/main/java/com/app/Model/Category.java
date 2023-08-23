package com.app.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private int catId;
     private String catName;
     @OneToMany(mappedBy = "category" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
     private Set<Plant> plant;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category(int catId, String catName) {
		super();
		this.catId = catId;
		this.catName = catName;
	}


	public int getCatId() {
		return catId;
	}


	public void setCatId(int catId) {
		this.catId = catId;
	}


	public String getCatName() {
		return catName;
	}


	public void setCatName(String catName) {
		this.catName = catName;
	}


	public Set<Plant> getPlant(Set<Plant> plant) {
		return plant;
	}


	public void setPlant(Set<Plant> plant) {
		this.plant = plant;
	}
     
	 
}
