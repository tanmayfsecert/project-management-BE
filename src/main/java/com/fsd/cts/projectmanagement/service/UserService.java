package com.fsd.cts.projectmanagement.service;

import com.fsd.cts.projectmanagement.dao.User;
import com.fsd.cts.projectmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User addNewUser(User user) {
		User n =new User();
		n.setFirstName(user.getFirstName());
		n.setLastName(user.getLastName());
		n.setEmployeeId(user.getEmployeeId());
		n.setUserId(123456);
		return userRepo.save(n);
	}

	public Iterable<User> findAll() {
		
		return userRepo.findAll();
	}

	 public User updateUser(User user) {
		User n = userRepo.findById(user.getUserId()).get();
		n.setEmployeeId(user.getEmployeeId());
		n.setFirstName(user.getFirstName());
		n.setLastName(user.getLastName());
		return n;
	} 


}
