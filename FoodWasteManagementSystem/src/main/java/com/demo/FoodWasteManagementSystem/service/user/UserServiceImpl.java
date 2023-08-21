package com.demo.FoodWasteManagementSystem.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.FoodWasteManagementSystem.beans.user.User;
import com.demo.FoodWasteManagementSystem.dao.user.UserDao;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserDao dao;
	
	@Override
	public List<User> findAllUser() {
		
		return dao.findAll();
	}
	
	@Override
	 public String addUser(User u) {
		   
		   dao.save(u);
		   
		  return "Registered Successfully";
		   
	   }
	
	
	@Override
	public User getUser(String username, String password) {
	    List<User> ulist = dao.findAll();

	    for (User u : ulist) {
	        if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
	            return u; // Return the user when a match is found
	        }
	    }

	    return null; // Return null if no matching user is found
	}

}
