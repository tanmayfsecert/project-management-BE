package com.fsd.cts.projectmanagement.service;

import com.fsd.cts.projectmanagement.dao.User;
import com.fsd.cts.projectmanagement.model.UserRequest;
import com.fsd.cts.projectmanagement.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository repo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void validate() {
		validateMockitoUsage();
	}

	@Test
	public void getAllUsersTest()

	{
		List<User> list = new ArrayList<User>();

		User taskOne = new User(1, "tanmay", "patra", "727496");
		User taskTwo = new User(2, "tanmay", "patra", "727496");
		User taskThree = new User(3, "tanmay", "patra", "727496");

		list.add(taskOne);
		list.add(taskTwo);
		list.add(taskThree);

		when(repo.findAll()).thenReturn(list);

		Iterable<User> taskList = userService.findAll();

		assertEquals(3, ((List<User>) taskList).size());
		verify(repo, times(1)).findAll();
	}

	@Test

	public void updateUserTest() {

//		 User n = userRepo.findOne(user.getUserId());
//			n.setEmployeeId(user.getEmployeeId());
//			n.setFirstName(user.getFirstName());
//			n.setLastName(user.getLastName());
//			return n;

		// User u = repo.findOne(123);
		User u = new User(1, "tanmay", "patra", "727496");
		User u1 = new User(12, "tan", "pat", "7274");
		
		u.setFirstName(u1.getFirstName());
		u.setLastName(u1.getLastName());
		u.setEmployeeId(u1.getEmployeeId());	
		//when(userService.updateUser(u)).thenReturn(u);
		
		when(repo.findById(123)).thenReturn(Optional.of(u));
		

	}

	@Test
	public void addNewUserTest() {

		User taskOne = new User(1, "tanmay", "patra", "727496");
		// userService.addNewUser(taskOne);
		when(userService.addNewUser(taskOne)).thenReturn(taskOne);
		when(repo.save(taskOne)).thenReturn(taskOne);

		// verify(repo, times(0).save(taskOne);

		/*
		 * User n =new User();
		 * 
		 * n.setFirstName(user.getFirstName()); n.setLastName(user.getLastName());
		 * n.setEmployeeId(user.getEmployeeId()); return userRepo.save(n);
		 */

	}

	@Test
	public void gettersSetters() {
		UserRequest u = new UserRequest();
		u.setFirstName("tanm");
		u.getFirstName();
		u.setLastName("vk");
		u.getLastName();
		u.setEmployeeId("12");
		u.getEmployeeId();
	}

}
