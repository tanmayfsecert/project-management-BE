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
public class ParentTask {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Integer parentId;
	
	private String parentTask;

//	public Integer getParentId() {
//		return parentId;
//	}
//
//	public void setParentId(Integer parentId) {
//		this.parentId = parentId;
//	}
//
//	public String getParentTask() {
//		return parentTask;
//	}
//
//	public void setParentTask(String parentTask) {
//		this.parentTask = parentTask;
//	}
	
	

}
