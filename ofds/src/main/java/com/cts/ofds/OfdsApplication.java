package com.cts.ofds;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cts.ofds.dao.DishDaoImpl;
import com.cts.ofds.dao.OrderDetailsDaoImpl;
import com.cts.ofds.dao.UserDaoImpl;
import com.cts.ofds.model.Dish;
import com.cts.ofds.model.OrderDetails;
import com.cts.ofds.model.User;

@SuppressWarnings("unused")
@SpringBootApplication
public class OfdsApplication {
	
	private static UserDaoImpl userDaoImpl;
	private static OrderDetailsDaoImpl orderDetailsDaoImpl;
	private static DishDaoImpl dishDaoImpl;
	
	@Autowired
	public OfdsApplication(UserDaoImpl userDaoImpl,DishDaoImpl dishDaoImpl,OrderDetailsDaoImpl orderDetailsDaoImpl) {
		OfdsApplication.userDaoImpl = userDaoImpl;
		OfdsApplication.orderDetailsDaoImpl = orderDetailsDaoImpl;
		OfdsApplication.dishDaoImpl=dishDaoImpl;
	}

	public static void main(String[] args) {
		SpringApplication.run(OfdsApplication.class, args);
		
	/*
		int response;
		
	 // Functional Testing Code for UserDao module Remove the paragraph comment and run it
		User user = new User("testuser101","Test User","Test",25,"user");
		response = userDaoImpl.add(user);
		System.out.println("Response for Row Creation : "+ response);
		List<User> userList = userDaoImpl.list();
		System.out.println("Get all response : ");
		userList.forEach(System.out::println);
		user.setName("Updated Test Name");
		response = userDaoImpl.update(user, "testuser101");
		System.out.println("Row Updation Response : "+response);
		Optional<User> fetchedUser = userDaoImpl.get("testuser101");
		System.out.println("Get Response : \n" + fetchedUser);
		response= userDaoImpl.delete("testuser101");
		System.out.println("Row Deletion Response : " + response);
		
	 // Functional Testing code for OrderDetailsDao Module remove the code below from comment to run
		OrderDetails orderDetails = new OrderDetails(2,"user2","q,q,qq","2021/12/01",500.02);		//Creating a new object for add
		response = orderDetailsDaoImpl.add(orderDetails);		
		System.out.println("Row Creation Response : "+response);				
		List<OrderDetails> orderDetailsList = orderDetailsDaoImpl.list();
		System.out.println("Get all response : ");
		orderDetailsList.forEach(System.out::println);
		orderDetails.setPrice(33.20);
		response = orderDetailsDaoImpl.update(orderDetails, 1);
		System.out.println("Row Updation Response : "+response);
		Optional<OrderDetails> fetchedOrderDetails = orderDetailsDaoImpl.get(2);
		System.out.println("Get Response : \n" + fetchedOrderDetails);
		response= orderDetailsDaoImpl.delete(2);
		System.out.println("Row Deletion Response : " + response);
		
	 // Functional Testing code for DishDao Module remove the code below from comment to run
		Dish dish = new Dish(1,"A",25.02,"Chinese Cuisine","Food");
		response = dishDaoImpl.add(dish);
		System.out.println("Row Creation Response : "+response);
		List<Dish> dishList = dishDaoImpl.list();
		System.out.println("Get all response : ");
		dishList.forEach(System.out::println);
		dish.setDescription("Updated Description");
		response = dishDaoImpl.update(dish, 1);
		System.out.println("Row Updation Response : " + response);
		Optional<Dish> fetchedDish = dishDaoImpl.get(1);
		System.out.println("Get Response : \n" + fetchedDish);
		response = dishDaoImpl.delete(1);
		System.out.println("Row deletion Response : " + response);
	*/
	}

}
