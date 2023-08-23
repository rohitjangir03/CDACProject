package com.app.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="plant")
public class Plant {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
      private int plantId;
	 @Column
      private String plantName;
	 @Column
      private double price;
	 @Column
      private boolean stock;
	 @Column
      private int quantity;
      @Column
      private String img;
      @Column
      private String description;
      
      @ManyToOne(fetch=FetchType.EAGER)
      private Category category;

	public Plant(int plantId, String plantName, double price, boolean stock, int quantity, String img,
			String description) {
		super();
		this.plantId = plantId;
		this.plantName = plantName;
		this.price = price;
		this.stock = stock;
		this.quantity = quantity;
		this.img = img;
		this.description = description;
	}
	
	public Plant() {
		
	}
	public int getPlantId() {
		return plantId;
	}
	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isStock() {
		if(this.quantity>0) {
		  this.setStock(true);	
		}
		return stock;
	}
	public void setStock(boolean stock) {
		this.stock = stock;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
      
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
}
