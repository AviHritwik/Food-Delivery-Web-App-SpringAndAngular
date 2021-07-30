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
import com.cts.ofds.service.DishService;
import com.cts.ofds.service.OrderDetailsService;
import com.cts.ofds.service.UserService;

@SuppressWarnings("unused")
@SpringBootApplication
public class OfdsApplication {
	/*
	private static UserDaoImpl userDaoImpl;
	private static OrderDetailsDaoImpl orderDetailsDaoImpl;
	private static DishDaoImpl dishDaoImpl;
	
	@Autowired
	public OfdsApplication(UserDaoImpl userDaoImpl,DishDaoImpl dishDaoImpl,OrderDetailsDaoImpl orderDetailsDaoImpl) {
		OfdsApplication.userDaoImpl = userDaoImpl;
		OfdsApplication.orderDetailsDaoImpl = orderDetailsDaoImpl;
		OfdsApplication.dishDaoImpl=dishDaoImpl;
	}*/

	private static UserService userService;
	private static OrderDetailsService orderService;
	private static DishService dishService;
	
	@Autowired
	public OfdsApplication(UserService userService,OrderDetailsService orderService,DishService dishService) {
		OfdsApplication.userService = userService;
		OfdsApplication.orderService = orderService;
		OfdsApplication.dishService=dishService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(OfdsApplication.class, args);
		
	/*
		boolean response;
		
	 // Functional Testing Code for UserDao module Remove the paragraph comment and run it
		User user = new User("testuser101","Test User","Test",25,"user");
		response = userService.add(user);
		System.out.println("Response for Row Creation : "+ response);
		List<User> userList = userService.getAll();
		System.out.println("Get all response : ");
		userList.forEach(System.out::println);
		user.setName("Updated Test Name");
		response = userService.update(user, "testuser101");
		System.out.println("Row Updation Response : "+response);
		Optional<User> fetchedUser = userService.get("testuser101");
		System.out.println("Get Response : \n" + fetchedUser);
		response= userService.delete("testuser101");
		System.out.println("Row Deletion Response : " + response);
		
	 // Functional Testing code for OrderDetailsDao Module remove the code below from comment to run
		OrderDetails orderDetails = new OrderDetails(2,"user2","q,q,qq","2021/12/01",500.02);		//Creating a new object for add
		response = orderService.add(orderDetails);		
		System.out.println("Row Creation Response : "+response);				
		List<OrderDetails> orderDetailsList = orderService.getAll();
		System.out.println("Get all response : ");
		orderDetailsList.forEach(System.out::println);
		orderDetails.setPrice(33.20);
		response = orderService.update(orderDetails, 1);
		System.out.println("Row Updation Response : "+response);
		Optional<OrderDetails> fetchedOrderDetails = orderService.get(2);
		System.out.println("Get Response : \n" + fetchedOrderDetails);
		response= orderService.delete(2);
		System.out.println("Row Deletion Response : " + response);
		
	 // Functional Testing code for DishDao Module remove the code below from comment to run
		Dish dish = new Dish(1,"A",25.02,"Chinese Cuisine","Food");
		response = dishService.add(dish);
		System.out.println("Row Creation Response : "+response);
		List<Dish> dishList = dishService.getAll();
		System.out.println("Get all response : ");
		dishList.forEach(System.out::println);
		dish.setDescription("Updated Description");
		response = dishService.update(dish, 1);
		System.out.println("Row Updation Response : " + response);
		Optional<Dish> fetchedDish = dishService.get(1);
		System.out.println("Get Response : \n" + fetchedDish);
		response = dishService.delete(1);
		System.out.println("Row deletion Response : " + response);
	*/
	}

}
