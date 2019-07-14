package com.fsd.cts.projectmanagement.service;

import com.fsd.cts.projectmanagement.dao.ParentTask;
import com.fsd.cts.projectmanagement.repository.ParentTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentTaskService {
	
	@Autowired
	private ParentTaskRepository repo;

	public Iterable<ParentTask> getAllUsers() {
		return repo.findAll();
	}
	
	

	public ParentTask addNew(String task) {
		ParentTask ptask = new ParentTask();
		ptask.setParentTask(task);
		return repo.save(ptask);
	}
	

}
