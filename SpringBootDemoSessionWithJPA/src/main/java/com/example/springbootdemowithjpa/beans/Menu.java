package com.example.springbootdemowithjpa.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
@Entity // informs the jpa that Menu is the entity class in persistence package.
public class Menu {
	@Id
	@ApiModelProperty(notes = "name of the food ")
	private String foodName;
	@ApiModelProperty(notes = "its cost")
	private Float cost;
	@ApiModelProperty(notes = "the category the food belongs to")
	private String type;
		
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
