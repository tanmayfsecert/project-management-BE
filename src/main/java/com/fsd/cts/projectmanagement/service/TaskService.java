package com.fsd.cts.projectmanagement.service;

import com.fsd.cts.projectmanagement.dao.ParentTask;
import com.fsd.cts.projectmanagement.dao.Project;
import com.fsd.cts.projectmanagement.dao.Task;
import com.fsd.cts.projectmanagement.dao.User;
import com.fsd.cts.projectmanagement.model.TaskObj;
import com.fsd.cts.projectmanagement.repository.ParentTaskRepository;
import com.fsd.cts.projectmanagement.repository.ProjectRepository;
import com.fsd.cts.projectmanagement.repository.TaskRepository;
import com.fsd.cts.projectmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private ParentTaskRepository repo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public String addNewTask(TaskObj task) {
		if(task.isParentTask()){
			ParentTask pTask = new ParentTask();
			pTask.setParentTask(task.getTaskName());
			repo.save(pTask);
		}else{
			Task t = new Task();
			t.setParentId(task.getParentTaskId());
			t.setProjectId(task.getProjectId());
			t.setTask(task.getTaskName());
			t.setStartDate(task.getStartDate());
			t.setEndDate(task.getEndDate());
			t.setPriority(task.getPriority());
			t.setUserId(task.getUserId());	
			t.setStatus("STARTED");
			taskRepo.save(t);
		}
		
		return "Saved";
	}
	
	
	public List<TaskObj> getAllTasks() {
		List<TaskObj> taskObjList = new ArrayList<>();
		List<Task> taskList =  (List<Task>) taskRepo.findAll();
		for(Task t: taskList){
			TaskObj obj = new TaskObj();
			obj.setTaskId(t.getTaskId());
			obj.setParentTaskId(t.getParentId());
			obj.setProjectId(t.getProjectId());
			obj.setTaskName(t.getTask());
			obj.setStartDate(t.getStartDate());
			obj.setEndDate(t.getEndDate());
			obj.setPriority(t.getPriority());
			obj.setStatus(t.getStatus());
			obj.setUserId(t.getUserId());
			if(t.getParentId() != null){
				ParentTask	 pTask = repo.findById(t.getParentId()).get();
				if(pTask != null){
					obj.setParentTaskName(pTask.getParentTask());
				}
			}
			if(t.getProjectId() != null){
				Project p = projectRepo.findById(t.getProjectId()).get();
				if(p != null){
					obj.setProjectName(p.getProject());
				}	
			}
			if(t.getUserId() != null){
				User u = userRepo.findById(t.getUserId()).get();
				if(u != null){
					obj.setUserName(u.getFirstName());
				}
			}
			
			taskObjList.add(obj);
			
		}
		
		return taskObjList;
	}
	
	

	public Task updateTask(TaskObj task) {
		Task	t = taskRepo.findById(task.getTaskId()).get();
		t.setParentId(task.getParentTaskId());
		t.setProjectId(task.getProjectId());
		t.setTask(task.getTaskName());
		t.setStartDate(task.getStartDate());
		t.setEndDate(task.getEndDate());
		t.setPriority(task.getPriority());
	    t.setStatus(task.getStatus());     
		return taskRepo.save(t);
	}


	public Iterable<TaskObj> getTasksByProject(Integer id) {
		 List<TaskObj> taskObjList = new ArrayList<>();
			List<Task> taskList = taskRepo.findAllByProjectId(id);
			for(Task t: taskList){
				TaskObj obj = new TaskObj();
				obj.setTaskId(t.getTaskId());
				obj.setParentTaskId(t.getParentId());
				obj.setProjectId(t.getProjectId());
				obj.setTaskName(t.getTask());
				obj.setStartDate(t.getStartDate());
				obj.setEndDate(t.getEndDate());
				obj.setPriority(t.getPriority());
				obj.setStatus(t.getStatus());
				obj.setUserId(t.getUserId());
				if(t.getParentId() != null){
					ParentTask pTask = repo.findById(t.getParentId()).get();
					if(pTask != null){
						obj.setParentTaskName(pTask.getParentTask());
					}
				}
				if(t.getProjectId() != null){
					Project p = projectRepo.findById(t.getProjectId()).get();
					if(p != null){
						obj.setProjectName(p.getProject());
					}	
				}
				if(t.getUserId() != null){
					User u = userRepo.findById(t.getUserId()).get();
					if(u != null){
						obj.setUserName(u.getFirstName());
					}
				}
				taskObjList.add(obj);
			}
			return taskObjList;
	}
	


}
