package com.fsd.cts.projectmanagement.restcontroller;

import com.fsd.cts.projectmanagement.dao.ParentTask;
import com.fsd.cts.projectmanagement.service.ParentTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("parenttask")
public class ParentTaskController {

	@Autowired
	private ParentTaskService parentTaskService;
	
	@GetMapping(value = "/all")
	public @ResponseBody
    Iterable<ParentTask> getAllUsers() {
		return parentTaskService.getAllUsers();
	}
	
	@PostMapping(value = "/add")
	public @ResponseBody
    ParentTask addNew (@RequestBody String task) {
		return parentTaskService.addNew(task);
	}

}
