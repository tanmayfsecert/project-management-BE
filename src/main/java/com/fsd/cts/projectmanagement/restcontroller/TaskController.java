package com.fsd.cts.projectmanagement.restcontroller;


import com.fsd.cts.projectmanagement.dao.Task;
import com.fsd.cts.projectmanagement.model.TaskObj;
import com.fsd.cts.projectmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("task")
public class TaskController {
	
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping(value = "/add")
	public @ResponseBody
    String addNewTask (@RequestBody TaskObj task) {

		return taskService.addNewTask(task);
	}

	@GetMapping(value = "/all")
	public @ResponseBody
    List<TaskObj> getAllTasks() {
		return taskService.getAllTasks();
	}
	
	@PutMapping(value = "/update")
	public @ResponseBody
	Task updateTask(@RequestBody TaskObj task){
		
		return taskService.updateTask(task);
	}
	
	/* @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteTask(@PathVariable("id") Integer id){
         taskRepo.delete(id);
	     return "return";
		
	} */
	
	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public @ResponseBody
    Iterable<TaskObj> getTasksByProject(@PathVariable("id") Integer id){
 
		return taskService.getTasksByProject(id);
		
	}

}
