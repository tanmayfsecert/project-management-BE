package com.fsd.cts.projectmanagement.repository;


import com.fsd.cts.projectmanagement.dao.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

}