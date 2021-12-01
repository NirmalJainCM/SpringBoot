package com.example.springbootdemowithjdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.springbootdemowithjdbc.beans.Menu;

@Repository
public class MenuRepository {

//	private Integer index;
	String query;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	MenuMapper mapper;
	
	public List<Menu> listAllItems(){
		query = "select * from menudetails;";
		return jdbcTemplate.query(query, mapper);
	}
	
	//getmenudetails using normal return statements
	public List<Menu> getMenuDetailsByType(String type) {
		query = "select * from menudetails where type = ?;";
		return jdbcTemplate.query(query, mapper, type);
	}
//	using streams to get the desired o/p
//	public void getMenuDetailsByType(String type) {
//		query = "select * from menudetails where type = ?;";
////		return jdbcTemplate.query(query, mapper, type);
//		
//		// mapper can also be used like this using streams
//	jdbcTemplate.query(query, (ResultSet rs, int rowNum) -> {
//		Menu theMenu = new Menu();
//		//	Map the fields of User to the columns of the table:userdetails
//			theMenu.setfoodName(rs.getString("foodName"));
//			theMenu.setCost(rs.getFloat("cost"));
//			theMenu.setType(rs.getString("type"));
//			return theMenu;
//	}, type).stream().forEach(System.out::println);
//	}
	


public void updateMenuItem(String food, Menu newItem) {
		query = "update menudetails set foodName= ?, cost = ?, type = ? where foodName = ?";
		jdbcTemplate.update(query, newItem.getfoodName(), newItem.getCost(), newItem.getType(), food);

	}
	
	
	public void deleteMenuItem(String food) {
		query = "delete from menudetails where foodName = ?";
		jdbcTemplate.update(query, food);
	}

	public void addToMenu(Menu newItem) {
		query = "insert into menudetails values(?, ?, ?);";
		jdbcTemplate.update(query, newItem.getfoodName(), newItem.getCost(), newItem.getType());
	}
	

		
}
@Component
class MenuMapper implements RowMapper<Menu>{

	@Override
	public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
		Menu theMenu = new Menu();
	//	Map the fields of User to the columns of the table:userdetails
		theMenu.setfoodName(rs.getString("foodName"));
		theMenu.setCost(rs.getFloat("cost"));
		theMenu.setType(rs.getString("type"));
		
		
		return theMenu;
	}
}
