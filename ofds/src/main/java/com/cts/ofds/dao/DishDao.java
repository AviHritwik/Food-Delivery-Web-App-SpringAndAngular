package com.cts.ofds.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.cts.ofds.model.Dish;

@Component
public class DishDao implements Dao<Dish,Integer>{

	JdbcTemplate jdbc;
	
	public DishDao(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}
	
	RowMapper<Dish> rowMapper = (rs,rowNum) -> {
		Dish dish = new Dish();
		dish.setDisdId(rs.getInt("dishId"));
		dish.setDishName(rs.getString("dishName"));
		dish.setDescription(rs.getString("description"));
		dish.setType(rs.getString("type"));
		dish.setPrice(rs.getDouble("price"));
		return dish;
	};
	
	@Override
	public List<Dish> list() {
		String sql = "select * from dish";
		List<Dish> dishList = jdbc.query(sql,rowMapper);
		return dishList;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Optional<Dish> get(Integer id) {
		String sql ="select * from dish where dishId = ?";
		Dish dish = null;
		try {
			dish = jdbc.queryForObject(sql, new Object[] {id}, rowMapper);
		}
		catch(DataAccessException ex) {
			System.out.println("Dish Not Found");
		}
		return Optional.ofNullable(dish);
	}

	@Override
	public int update(Dish t, Integer id) {
		String sql = "update dish set dishName = ? , price = ? , description = ? ,type = ? where dishId = ?";
		int response = jdbc.update(sql,t.getDishName(),t.getPrice(),t.getDescription(),t.getType(),id);
		return response;
	}

	@Override
	public int add(Dish t) {
		String sql = "insert into dish(dishId,dishName,price,description,type) values (?,?,?,?,?)";
		int response = jdbc.update(sql,t.getDisdId(),t.getDishName(),t.getPrice(),t.getDescription(),t.getType());
		return response;
	}

	@Override
	public int delete(Integer id) {
		String sql = "delete from dish where dishId = ?";
		int response = jdbc.update(sql,id);
		return response;
	}
}
