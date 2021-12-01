package com.example.springbootdemowithjdbc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemowithjdbc.beans.Menu;
import com.example.springbootdemowithjdbc.service.MenuService;

@RestController()
@RequestMapping("menu")
public class MenuController {
	
	@Autowired
	MenuService newService;

	
	@RequestMapping("list")
	public List<Menu> listAllItems(){
		return newService.listAllItems();
	}
	
	// just enter the url in menu/food
	@RequestMapping("list/{type}")
	public List<Menu> getMenuDetailsByType(@PathVariable String type) {
		return newService.getMenuDetailsByType(type);
	}
	
	
	//to add elements into the list use request mapping in the below format
//	@RequestMapping(method = RequestMethod.POST, value = "menu")
	
	// or just use post annotation in the mentioned format and use postman
	@PostMapping("list")
	public void addToMenu(@RequestBody Menu newItem) {
		newService.addToMenu(newItem);
		System.out.println("the item "+ newItem.getfoodName()+ " has been added");
	}
	
	//old method
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
	public String updateMenuItem(@PathVariable String food, @RequestBody Menu menuDetails) {
		newService.updateMenuItem(food, menuDetails);
		return "the item "+ food + " has been edited";
	}
	@DeleteMapping("list/{food}")
	String deleteMenuItem(@PathVariable String food) {
		newService.deleteMenuItem(food);
		return "the item "+food + " has been deleted";
	}
	
	
	//old method
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
