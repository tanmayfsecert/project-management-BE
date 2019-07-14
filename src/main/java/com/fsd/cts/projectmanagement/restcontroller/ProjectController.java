package com.fsd.cts.projectmanagement.restcontroller;


import com.fsd.cts.projectmanagement.model.ProjectObj;
import com.fsd.cts.projectmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping()
	public @ResponseBody
	ProjectObj addProject(@RequestBody ProjectObj p){
		return projectService.addProject(p);
	}
	
	@PutMapping
	public @ResponseBody
    ProjectObj updateProject(@RequestBody ProjectObj p){
		
	return projectService.updateProject(p);
	}
	
	@GetMapping(value = "/all")
	public @ResponseBody
    List<ProjectObj> getAllProject() {
		
		return projectService.getAllProject();
	}
	
	
	
}
