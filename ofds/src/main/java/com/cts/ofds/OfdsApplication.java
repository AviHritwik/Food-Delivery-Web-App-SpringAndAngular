package com.cts.ofds;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cts.ofds.dao.DishDao;
import com.cts.ofds.dao.OrderDetailsDao;
import com.cts.ofds.dao.UserDao;
import com.cts.ofds.model.Dish;
import com.cts.ofds.model.OrderDetails;
import com.cts.ofds.model.User;

@SuppressWarnings("unused")
@SpringBootApplication
public class OfdsApplication {
	
	private static UserDao userDao;
	private static OrderDetailsDao orderDetailsDao;
	private static DishDao dishDao;
	
	public OfdsApplication(UserDao userDao,DishDao dishDao,OrderDetailsDao orderDetailsDao) {
		OfdsApplication.userDao = userDao;
		OfdsApplication.orderDetailsDao = orderDetailsDao;
		OfdsApplication.dishDao=dishDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(OfdsApplication.class, args);
		
	/**
	 // Functional Testing Code for UserDao module Remove the paragraph comment and run it
		User user = new User();
		user=userList.get(0);
		user.setName("ABC");
		System.out.println(userDao.update(user, "user1"));
		userList = userDao.list();
		userList.forEach(System.out::println);
		Optional<User> fetchedUser = userDao.get("user1");
		System.out.println(fetchedUser);
		User newUser = new User("user4","GHJ","abcdf",50,"user");
		System.out.println(userDao.add(newUser));
		System.out.println(userDao.delete("user5"));
	
	 // Functional Testing code for OrderDetailsDao Module remove the code below from comment to run
		OrderDetails orderDetails = new OrderDetails(2,"user2","q,q,qq","2021/12/01",500.02);		//Creating a new object for add
		int response = orderDetailsDao.add(orderDetails);		
		System.out.println("Row Creation Response : "+response);				
		List<OrderDetails> orderDetailsList = orderDetailsDao.list();
		System.out.println("Get all response : ");
		orderDetailsList.forEach(System.out::println);
		orderDetails.setPrice(33.20);
		response = orderDetailsDao.update(orderDetails, 1);
		System.out.println("Row Updation Response : "+response);
		Optional<OrderDetails> fetchedOrderDetails = orderDetailsDao.get(2);
		System.out.println("Get Response : \n" + fetchedOrderDetails);
		response= orderDetailsDao.delete(2);
		System.out.println("Row Deletion Response : " + response);
		
		// Functional Testing code for DishDao Module remove the code below from comment to run
		Dish dish = new Dish(1,"A",25.02,"Chinese Cuisine","Food");
		int response = dishDao.add(dish);
		System.out.println("Row Creation Response : "+response);
		List<Dish> dishList = dishDao.list();
		System.out.println("Get all response : ");
		dishList.forEach(System.out::println);
		dish.setDescription("Updated Description");
		response = dishDao.update(dish, 1);
		System.out.println("Row Updation Response : " + response);
		Optional<Dish> fetchedDish = dishDao.get(1);
		System.out.println("Get Response : \n" + fetchedDish);
		response = dishDao.delete(1);
		System.out.println("Row deletion Response : " + response);
	*/
	}

}
