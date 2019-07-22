package com.brados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.brados.dao.UserDao;
import com.brados.model.User;

@Service("userManager")
public class UserServiceImpl implements UserService{
	
	@Autowired
	@Qualifier("userRepo")
	private UserDao userRepo;
	public void setUserRepo(UserDao userRepo) {
		this.userRepo = userRepo;
	}

	//@Override
	public List<User> getAllUsers() {
		return userRepo.getAllUsers();
	}
	
	@Override
	public void addUser(User user) {
		userRepo.save(user);
	}

	@Override
	public void updateUser(User user) {
		userRepo.update(user);
	}

	@Override
	public void deleteUser(int userId) {
		userRepo.delete(userId);
	}

	@Override
	public User getUserById(int userId) {
		return userRepo.getUserById(userId);
	}

}
