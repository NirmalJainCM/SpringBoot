package com.example.springbootdemowithjpa.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemowithjpa.beans.Menu;
import com.example.springbootdemowithjpa.service.MenuService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Menu List Rest API" , description = "hotel menus")
@RequestMapping("menu")
public class MenuController {
	
	@Autowired
	MenuService newService;

	
	@RequestMapping("list")
	@ApiOperation(value = "Find all the menu items", notes = "hit this end point for fetching all the menu items")
	public Iterable<Menu> listAllItems(){
		return newService.listAllItems();
	}

	@RequestMapping("list/{type}")
	@ApiOperation(value = "Find all the menu items vy type", notes = "hit this end point for fetching all the menu items by a particular type")
	public Optional<Menu> getMenuDetailsByType(@PathVariable String type) {
		Optional<Menu> newMenu = null;
		try {
			newMenu = newService.getMenuDetailsByType(type);
		}
		catch(NoSuchElementException e) { 
			return Optional.empty();
		}
		
		return newMenu;
	}
	

	@PostMapping("list")
	@ApiOperation(value = "Add a menu item", notes = "hit this end point for pushing a data object")
	public void addToMenu(@RequestBody Menu newItem) {
		newService.addToMenu(newItem);
		System.out.println("the item "+ newItem.getfoodName()+ " has been added");
	}
	

	//	here we dont even need to mention the foodname to search for it and then update it, 
	//	just by entering the object of type menu we can make changes to the database and also {food} 
	//	is not required in putmapping its just to make it more readable
	
	@PutMapping("list/{food}")
	@ApiOperation(value = "Edit a menu item", notes = "hit this end point for editing a menu item")

	public String updateMenuItem( @RequestBody Menu menuDetails) {
		newService.updateMenuItem(menuDetails);
		return "the item "+ menuDetails.getfoodName()+ " has been edited";
	}
	
	@DeleteMapping("list/{food}")
	@ApiOperation(value = "delete an item", notes = "hit this end point for deleting a menu item using the foodName")

	String deleteMenuItem(@PathVariable String food) {
		newService.deleteMenuItem(food);
		return "the item "+food + " has been deleted";
	}
	

}
