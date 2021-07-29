package com.cts.ofds.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.cts.ofds.model.User;

@Component
public class UserDao implements Dao<User,String>{
	
	JdbcTemplate jdbc;
	
	public UserDao(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}
	
	RowMapper<User> rowMapper = (rs,rowNum) -> {
		User user = new User();
		user.setUserId(rs.getString("userId"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getString("role"));
		user.setAge(rs.getInt("age"));
		return user;
	};

	@Override
	public List<User> list() {
		String sql = "select * from user";
		List<User> userList = jdbc.query(sql, rowMapper);
		System.out.println(userList);
		return userList;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<User> get(String id) {
		String sql = "select * from  user where userId=?";
		User user = null;
		try {
			user = jdbc.queryForObject(sql, new Object[] {id}, rowMapper);
		}
		catch(DataAccessException ex) {
			System.out.println("User Not Found");
		}
		return Optional.ofNullable(user);
	}

	@Override
	public int update(User t, String id) {
		String sql = "update user set name = ? , password = ? , role = ? ,age = ? where userId = ?";
		int response = jdbc.update(sql, t.getName(),t.getPassword(),t.getRole(),t.getAge(),id);
		return response;
	}

	@Override
	public int add(User t) {
		String sql = "insert into user(userId,name,password,role,age) values ( ?,?,?,?,?)";
		int response = jdbc.update(sql, t.getUserId(),t.getName(),t.getPassword(),t.getRole(),t.getAge());
		return response;
	}

	@Override
	public int delete(String id) {
		String sql = "delete from user where userId = ?";
		int response = jdbc.update(sql,id);
		return response;
	}
}
