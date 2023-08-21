package com.demo.FoodWasteManagementSystem.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.FoodWasteManagementSystem.beans.user.User;
import com.demo.FoodWasteManagementSystem.service.user.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController{	
	
	@Autowired
	UserService service;
	
		
	@GetMapping("/getuser")
	public List<User> getAllUser()
	{
		
		List<User> ulist= service.findAllUser();
		return ulist;
	}
	
//	@PostMapping("/register")
//	public String addNewUser(@Valid @RequestBody User u)
//	{
//		return service.addUser(u);
//		
//	}
	
//	@PostMapping("/login/{email}/{password}")
//	public User ValidateUser(@PathVariable String password,@PathVariable String email) {
//
//		return service.getUser(password,email);
////		List<Address> ad=new ArrayList<Address>();
////		ad.add(new Address("asdf","asdfasd","asd","aff",57));
////		User user=new User("sid","shubhajm","234235","abc","abc",ad,1);
////		user.setUid(10);
////		if(user.getEmail().equals(email) && user.getPassword().equals(password))
////		{
////			return user;
////		}
////		return null;
////	}
//}
	
//	
//	@PostMapping("/register")
//	public ResponseEntity<String> registerUser(@RequestBody User user) {
//                      service.addUser(user);
//	    	    return ResponseEntity.ok("Registration successful");
//	}
	
	
	@PostMapping("/register")
	public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
	    service.addUser(user);
	    Map<String, String> response = new HashMap<>();
	    response.put("message", "Registration successful");
	    return ResponseEntity.ok(response);
	}

	@PostMapping("/login")
	public User ValidateUser(@RequestBody Map<String, String> credentials) {
		   System.out.println("Request Payload: " + credentials.toString());
	    String username = credentials.get("username");
	    String password = credentials.get("password");
	    System.out.println("username in route"+username);

	    return service.getUser(password, username);
	}

	
	
}
