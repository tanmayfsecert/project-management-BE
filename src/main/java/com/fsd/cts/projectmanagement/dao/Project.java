package com.fsd.cts.projectmanagement.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Integer projectId;
	private String project;
	private Date startDate;
	private Date endDate;
	private Integer priority;
	private Integer userId;

//	public Integer getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//
//	public Integer getProjectId() {
//		return projectId;
//	}
//
//	public void setProjectId(Integer projectId) {
//		this.projectId = projectId;
//	}
//
//	public String getProject() {
//		return project;
//	}
//
//	public void setProject(String project) {
//		this.project = project;
//	}
//
//	public Date getStartDate() {
//		return startDate;
//	}
//
//	public void setStartDate(Date startDate) {
//		this.startDate = startDate;
//	}
//
//	public Date getEndDate() {
//		return endDate;
//	}
//
//	public void setEndDate(Date endDate) {
//		this.endDate = endDate;
//	}
//
//	public Integer getPriority() {
//		return priority;
//	}
//
//	public void setPriority(Integer priority) {
//		this.priority = priority;
//	}
	
	
}
