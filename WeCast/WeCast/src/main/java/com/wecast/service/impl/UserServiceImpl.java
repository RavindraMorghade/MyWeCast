package com.wecast.service.impl;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecast.exception.ServiceException;
import com.wecast.repo.UserRepository;
import com.wecast.request.User;
import com.wecast.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		String newPassword=user.getPassword();
		 Encoder encoder = Base64.getEncoder();
		 String encodedPassword=encoder.encodeToString(newPassword.getBytes());
		 System.out.println("Encoded Password"+encodedPassword);
		 user.setPassword(encodedPassword);
		User returnUser = userRepository.save(user);
		return returnUser;
		
	}
	
	
	  public User findByEmailAndPassword(String email, String password) throws ServiceException {
		  Encoder encoder = Base64.getEncoder();
		String encodedPassword =  encoder.encodeToString(password.getBytes());
	  Optional<User> user = userRepository.findByEmailAndPassword(email,encodedPassword);
	  if(user.isPresent()) {
		  return user.get(); 
		  } else {
	  //System.out.println("Record not present"); 
			  throw new ServiceException("Record not present for such email and password");
	  }
	  }
	 

	@Override
	public User updateUser(int id ,User user) throws ServiceException{
		User user1 = null;
		Optional<User> newuser= userRepository.findById(id);
		  if(newuser.isPresent()) {
			  user1 = newuser.get();
			 user1.setName(user.getName());
			 user1.setLastName(user.getLastName());
			 user1.setDob(user.getDob());
			 user1.setEmail(user.getEmail());
			 user1.setPassword(user.getPassword());
			 user1.setRegDate(user.getRegDate());
			 user1.setAddress(user.getAddress());
			 user1.setMeasurement(user.getMeasurement());
			  userRepository.save(user);
		  }else {
			  //System.out.println("User not found");
			  throw new ServiceException("User not found for given id..");
		  }
		  return user1;
	}


	@Override
	public User findById(int id) throws ServiceException{
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			  return user.get(); 
			  } else {
		  throw new ServiceException("Record not present"); 
		  }
	}


	@Override
	public List<User> findAllUsers() throws ServiceException{
	List<User> user = userRepository.findAll();
	if(user.isEmpty()) {
		throw new ServiceException("No users present..");
	}
	return user;
	}


	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);
		System.out.println("User deleted successfully");
	}
	
	@Override
	public List<User> getFriendsSuggestion(String city){
		List<User> suggList=userRepository.getFriendsSuggestion(city);
		return suggList;
		
	}
	 
	
	
}
