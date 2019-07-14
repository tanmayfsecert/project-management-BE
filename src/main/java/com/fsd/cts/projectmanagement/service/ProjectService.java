package com.fsd.cts.projectmanagement.service;

import com.fsd.cts.projectmanagement.dao.Project;
import com.fsd.cts.projectmanagement.dao.User;
import com.fsd.cts.projectmanagement.model.ProjectObj;
import com.fsd.cts.projectmanagement.repository.ProjectRepository;
import com.fsd.cts.projectmanagement.repository.TaskRepository;
import com.fsd.cts.projectmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	TaskRepository taskRepo;
	
	public ProjectObj addProject(ProjectObj p) {
		Project project = new Project();
		project.setProject(p.getProjectName());
		project.setStartDate(p.getStartDate());
		project.setEndDate(p.getEndDate());
		project.setPriority(p.getPriority());
		project.setUserId(p.getUserId());
		projectRepository.save(project);
		p.setCompletedTaskNumber(0);
		p.setTaskNumber(0);
		return p;
	}
	
	public ProjectObj updateProject(ProjectObj p) {
		Project project = projectRepository.findById(p.getProjectId()).get();
		if(project!= null){
			project.setProject(p.getProjectName());
			project.setStartDate(p.getStartDate());
			project.setEndDate(p.getEndDate());
			project.setPriority(p.getPriority());
			project.setUserId(p.getUserId());
			projectRepository.save(project);
			return p;
		}else{
			return null;
		}	
	}
	
	public List<ProjectObj> getAllProject() {
		 Iterable<Project> projectList =  projectRepository.findAll();
		 List<ProjectObj> projectResponseList = new ArrayList<>();
		 for(Project project: projectList){
			 ProjectObj  p = new ProjectObj();
			 p.setProjectId(project.getProjectId());
			 p.setProjectName(project.getProject());
			 p.setStartDate(project.getStartDate());
			 p.setEndDate(project.getEndDate());
			 p.setPriority(project.getPriority());
			 p.setTaskNumber(taskRepo.findAllByProjectId(project.getProjectId()).size());
			 p.setCompletedTaskNumber(taskRepo.findAllByProjectIdAndStatus(project.getProjectId(), "COMPLETED").size());
			 p.setUserId(project.getUserId());
			 if(project.getUserId() != null){
				 User u = userRepository.findById(project.getUserId()).get();
				 if( u != null){
					 p.setManager(u.getFirstName());
				 }
			 }
			 
			 projectResponseList.add(p);
		 }
		
		return projectResponseList;
	}
}
