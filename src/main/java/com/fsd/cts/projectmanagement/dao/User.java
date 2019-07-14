package com.fsd.cts.projectmanagement.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer userId;
    private String firstName;
    private String lastName;
    private String employeeId;
    
//	public Integer getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getEmployeeId() {
//		return employeeId;
//	}
//
//	public void setEmployeeId(String employeeId) {
//		this.employeeId = employeeId;
//	}
    
}
