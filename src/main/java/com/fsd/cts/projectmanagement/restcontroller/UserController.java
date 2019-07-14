package com.fsd.cts.projectmanagement.restcontroller;


import com.fsd.cts.projectmanagement.dao.User;
import com.fsd.cts.projectmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping(value = "/add")
	public @ResponseBody
	User addNewUser (@RequestBody User user) {
		return userService.addNewUser(user);
	}

	@GetMapping(value = "/all")
	public @ResponseBody
    Iterable<User> getAllUsers() {
		return userService.findAll();
	}
	
	@PutMapping(value = "/update")
	public @ResponseBody
    User updateUser(@RequestBody User user){
		return userService.updateUser(user);
	}

}

