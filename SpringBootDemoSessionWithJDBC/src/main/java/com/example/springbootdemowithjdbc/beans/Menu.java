package com.example.springbootdemowithjdbc.beans;

public class Menu {
	private String foodName;
	private Float cost;
	private String type;
	@Override
	public String toString() {
		return "Menu [foodName=" + foodName + ", cost=" + cost + ", type=" + type + "]";
	}
	public String getfoodName() {
		return foodName;
	}
	public void setfoodName(String foodName) {
		this.foodName = foodName;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Menu(String foodName, Float d, String type) {
		super();
		this.foodName = foodName;
		this.cost = d;
		this.type = type;
	}
	public Menu() {
		super();
}
	

}
