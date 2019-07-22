package com.brados.service;

import java.util.List;

import com.brados.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(int userId);
	User getUserById(int userId);

}
