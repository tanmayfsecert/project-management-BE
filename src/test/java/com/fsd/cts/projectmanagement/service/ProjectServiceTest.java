package com.fsd.cts.projectmanagement.service;


import com.fsd.cts.projectmanagement.dao.Project;
import com.fsd.cts.projectmanagement.model.ProjectObj;
import com.fsd.cts.projectmanagement.repository.ProjectRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class ProjectServiceTest {
	 @InjectMocks
	    ProjectService service;
	     
	    @Mock
		ProjectRepository repo;
	 
	    @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }

	
	  @Test
	    public void addProjectTest() throws ParseException
	    {/*Project project = new Project();
		project.setProject(p.getProjectName());
		project.setStartDate(p.getStartDate());
		project.setEndDate(p.getEndDate());
		project.setPriority(p.getPriority());
		project.setUserId(p.getUserId());
		projectRepository.save(project);
		p.setCompletedTaskNumber(0);
		p.setTaskNumber(0);
		return p;*/
	     //Integer projectId, String project, Date startDate, Date endDate, Integer priority, Integer userId
		  
		  SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		  String startDate = "15-10-2015";
		  Date dateOne = sdf.parse(startDate);
		  
		  SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		  String endDate = "15-10-2015";
		  Date dateTwo = sdf.parse(startDate);
		  
		  Project project = new Project(1,"project",dateOne,dateTwo,1,123);
		  
		  ProjectObj p=new ProjectObj();
		 
			
		         
		        service.addProject(p);
		         
		        // ((ProjectService) verify(repo, times(0))).addProject(p);
	    }
	  
	  @Test
	  
	  public void updateProject() throws ParseException {
		  /*Project project = projectRepository.findOne(p.getProjectId());
		if(project!= null){
			project.setProject(p.getProjectName());
			project.setStartDate(p.getStartDate());
			project.setEndDate(p.getEndDate());
			project.setPriority(p.getPriority());
			project.setUserId(p.getUserId());
			projectRepository.save(project);
			return p;*/
		
		  
		  ProjectObj p = new ProjectObj();
		  SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		  String startDate = "15-10-2015";
		  Date dateOne = sdf.parse(startDate);
		  
		  SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		  String endDate = "15-10-2015";
		  Date dateTwo = sdf.parse(startDate);	  
		 
		  Project project = new Project(1,"project",dateOne,dateTwo,1,123);
		  Project project2 = new Project(1,"project12",dateOne,dateTwo,23,12);
		  when(repo.findById(123)).thenReturn(Optional.of(project2));
		  
		  
		 project2.setProject(project.getProject());
		  project2.setStartDate(project.getStartDate());
			project2.setEndDate(project.getEndDate());
			project2.setPriority(project.getPriority());
			project2.setUserId(project.getUserId());
			repo.save(project2);
	  }
	  
	  @Test
	  public void getAllProject()
	  {
		 
		  Iterable<Project> projectList = new  ArrayList<Project>();
		  when(repo.findAll()).thenReturn(projectList);
		
			 List<ProjectObj> projectResponseList = new ArrayList<>();
		  
		  /*Iterable<Project> projectList =  projectRepository.findAll();
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
				 User  u = userRepository.findOne(project.getUserId());
				 if( u != null){
					 p.setManager(u.getFirstName());
				 }
			 }
			 
			 projectResponseList.add(p);
		 }
		
		return projectResponseList;*/
	  }
	  
	  @Test
	  
	  public void setAndGetProjectId()
	  {
		  Project p = new Project();
		  p.setProjectId(1);
		  p.getProjectId();
	  }

}
