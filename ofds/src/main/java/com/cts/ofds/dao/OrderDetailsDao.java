package com.cts.ofds.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.cts.ofds.model.OrderDetails;

@Component
public class OrderDetailsDao implements Dao<OrderDetails,Integer>{
	
	JdbcTemplate jdbc;
	
	public OrderDetailsDao(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}
	
	RowMapper<OrderDetails> rowMapper = (rs,rowNum) -> {
		OrderDetails order = new OrderDetails();
		order.setOrderId(rs.getInt("orderId"));
		order.setUserId(rs.getString("userId"));
		order.setDishes(rs.getString("dishes"));
		order.setPrice(rs.getDouble("price"));
		order.setOrderDate(rs.getString("orderDate"));
		return order;
	};
	
	@Override
	public List<OrderDetails> list() {
		String sql = "select * from orderdetails";
		List<OrderDetails> orderList = jdbc.query(sql, rowMapper);
		return orderList;
	}

	@Override
	public int add(OrderDetails t) {
		String sql = "insert into orderdetails(orderId,userId,dishes,price,orderDate) values (?,?,?,?,?)";
		int response = jdbc.update(sql, t.getOrderId(),t.getUserId(),t.getDishes(),t.getPrice(),t.getOrderDate());
		return response;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<OrderDetails> get(Integer id) {
		String sql = "select * from  orderdetails where orderId=?";
		OrderDetails order = null;
		try {
			order = jdbc.queryForObject(sql, new Object[] {id}, rowMapper);
		}
		catch(DataAccessException ex) {
			System.out.println("User Not Found");
		}
		return Optional.ofNullable(order);
	}

	@Override
	public int update(OrderDetails t, Integer id) {
		String sql = "update orderdetails set dishes = ? , price = ? where orderId = ?";
		int response = jdbc.update(sql,t.getDishes(),t.getPrice(),id);
		return response;
	}

	@Override
	public int delete(Integer id) {
		String sql = "delete from orderdetails where orderId = ?";
		int response = jdbc.update(sql,id);
		return response;
	}

}
