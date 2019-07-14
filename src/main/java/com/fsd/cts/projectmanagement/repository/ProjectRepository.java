package com.fsd.cts.projectmanagement.repository;

import com.fsd.cts.projectmanagement.dao.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Integer> {

}
