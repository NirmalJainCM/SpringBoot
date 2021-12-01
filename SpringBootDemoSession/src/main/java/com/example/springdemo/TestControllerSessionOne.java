package com.example.springdemo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("menu")
@RestController
public class TestControllerSessionOne {
	
	
	List<Menu> menu = new ArrayList<>(Arrays.asList(
			new Menu("Dosa", (float) 49.99, "South Indian"),
			new Menu("Idli", (float) 29.99, "South Indian"),
			new Menu("Noodles", (float) 149.99, "Chinese"),
			new Menu("Soup", (float) 50.15, "Starters")	
		));
	private Integer index;
	
	@RequestMapping("list")
	List<Menu> listAllItems(){
		//System.out.println("we are here");
		return menu;
	}
	
	// just enter the url in menu/food
	@RequestMapping("list/{type}")
	Menu getMenuDetailsByType(@PathVariable String type) {
		
		return menu.stream()
				.filter(key -> key.getType().equals(type))
				.findAny()
				.get();
		
	}
	
	
	//to add elements into the list use request mapping in the below format
//	@RequestMapping(method = RequestMethod.POST, value = "menu")
	
	// or just use post annotation in the mentioned format and use postman
	@PostMapping("list")
	void addToMenu(@RequestBody Menu newItem) {
		menu.add(newItem);
	}
	
//	@PutMapping("list/{food}")
//	void updateMenuItem(@PathVariable String food, @RequestBody Menu menuDetails){
//		{
//			for(Menu menuIter : menu) {
//				if(menuIter.getFood().equals(food)) {
//					menu.set(menu.indexOf(menuIter), menuDetails);
//				}
//			}
//		}
//	}
	
	@PutMapping("list/{food}")
	void updateMenuItem(@PathVariable String food, @RequestBody Menu menuDetails) {
		Menu update = menu.stream()
		.filter(item->item.getFood().equals(food))
		.findFirst()
		.get();
		update.setFood(menuDetails.getFood());
		update.setCost(menuDetails.getCost());
		update.setType(menuDetails.getType());
	}
	
	@DeleteMapping("list/{food}")
	void deleteMenuItem(@PathVariable String food) {
		menu.removeIf(item -> item.getFood().equals(food));
	}
	
	
	
//	@DeleteMapping("list/{food}")
//	void deleteMenuItem(@PathVariable String food) {
//		Integer index = 0;
//		for(Menu menuIter : menu) {
//			if(menuIter.getFood().equals(food)) {
//				index = menu.indexOf(menuIter);
//			}
//		}
//		//menu.remove(index);
//		System.out.println("the id is deleted"+menu.get(index));
//		menu.removeIf(item -> item.getFood().equals(food));
//		
////		menu.remove(index);
//		System.out.println("the item is deleted");
//	}
}

