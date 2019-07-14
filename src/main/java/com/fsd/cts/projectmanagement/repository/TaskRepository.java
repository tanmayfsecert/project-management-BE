package com.fsd.cts.projectmanagement.repository;


import com.fsd.cts.projectmanagement.dao.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task,Integer> {

	List<Task> findAllByProjectId(Integer id);
		
	List<Task> findAllByProjectIdAndStatus(Integer id, String status);
	
}
