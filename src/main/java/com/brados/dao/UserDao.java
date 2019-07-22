package com.brados.dao;

import java.util.List;

import com.brados.model.User;

public interface UserDao {
	
	void save(User user);
	List<User> getAllUsers();
	void update(User user);
	void delete(int userId);
	User getUserById(int id);
	
}
