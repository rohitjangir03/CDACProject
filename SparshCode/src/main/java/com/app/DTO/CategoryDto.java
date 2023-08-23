package com.app.DTO;

public class CategoryDto {
	
     private int catId;
     private String catName;
     
     
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CategoryDto(int catId, String catName) {
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
	 
     
}
