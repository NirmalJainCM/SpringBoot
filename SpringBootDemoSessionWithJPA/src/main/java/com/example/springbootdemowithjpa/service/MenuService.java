package com.example.springbootdemowithjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootdemowithjpa.beans.Menu;
import com.example.springbootdemowithjpa.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	MenuRepository repo;
	
	public Iterable<Menu> listAllItems(){
		return repo.findAll();
	}
	
//	implementation for menu details without streams and lambdas
	public Optional<Menu> getMenuDetailsByType(String type) {
		return repo.findById(type);	
	}
	
	
		
	public void addToMenu(Menu newItem) {
		repo.save(newItem);
	}
	
	public void updateMenuItem(Menu menuDetails) {
		repo.save(menuDetails);
	}
	
	public void deleteMenuItem(String food) {
		repo.deleteById(food);
	}
	
}

