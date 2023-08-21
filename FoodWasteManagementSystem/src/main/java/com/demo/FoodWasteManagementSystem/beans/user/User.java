package com.demo.FoodWasteManagementSystem.beans.user;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	private String username;
	private String password;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int uid, String username, String password) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + "]";
	}
	
		





}
