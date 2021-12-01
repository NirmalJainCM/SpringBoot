package com.example.springbootdemowithjdbc.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootdemowithjdbc.beans.Menu;
import com.example.springbootdemowithjdbc.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	MenuRepository repo;
	
	public List<Menu> listAllItems(){
		return repo.listAllItems();
	}
	
//	implementation for menu details without streams and lambdas
	public List<Menu> getMenuDetailsByType(String type) {
		return repo.getMenuDetailsByType(type);	
	}
	
	
		
	public void addToMenu(Menu newItem) {
		repo.addToMenu(newItem);
	}
	
	public void updateMenuItem(String food, Menu menuDetails) {
		repo.updateMenuItem(food, menuDetails);
	}
	
	public void deleteMenuItem(String food) {
		repo.deleteMenuItem(food);
	}
	
}

