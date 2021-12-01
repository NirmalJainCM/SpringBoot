package com.example.springdemo;

public class Menu {
	private String food;
	private Float cost;
	private String type;
	@Override
	public String toString() {
		return "Menu [food=" + food + ", cost=" + cost + ", type=" + type + "]";
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
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
	public Menu(String food, Float d, String type) {
		super();
		this.food = food;
		this.cost = d;
		this.type = type;
	}
	

}
