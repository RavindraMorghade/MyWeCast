package com.wecast.service;

import java.util.List;

import com.wecast.exception.ServiceException;
import com.wecast.request.User;

public interface UserService {

	public User addUser(User user);

	public User findByEmailAndPassword(String email, String password)throws ServiceException;

	public User updateUser(int id ,User user) throws ServiceException;
	
	public User findById(int id);
	
	public List<User> findAllUsers() throws ServiceException;
	
	public void deleteById(int id);

	List<User> getFriendsSuggestion(String city);


}
