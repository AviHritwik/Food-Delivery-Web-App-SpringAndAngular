package com.cts.ofds.model;

public class Dish {
	private int disdId;
	private String dishName;
	private double price;
	private String description;
	private String type;
	
	
	public Dish() {
	}
	public Dish(int disdId, String dishName, double price, String description, String type) {
		this.disdId = disdId;
		this.dishName = dishName;
		this.price = price;
		this.description = description;
		this.type = type;
	}
	public int getDisdId() {
		return disdId;
	}
	public void setDisdId(int disdId) {
		this.disdId = disdId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Dish [disdId=" + disdId + ", dishName=" + dishName + ", price=" + price + ", description=" + description
				+ ", type=" + type + "]";
	}
	
}
