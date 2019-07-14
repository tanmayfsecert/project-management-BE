package com.fsd.cts.projectmanagement.service;


import com.fsd.cts.projectmanagement.dao.ParentTask;
import com.fsd.cts.projectmanagement.repository.ParentTaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ParentTaskServiceTest {

    @InjectMocks
    ParentTaskService service;

    @Mock
    ParentTaskRepository repo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void addNewTest() {
        ParentTask ptask = new ParentTask();
        String task = "parentTask";

        ptask.setParentTask(task);
        when(service.addNew(task)).thenReturn(ptask);
        when(repo.save(ptask)).thenReturn(ptask);
        verify(repo, times(0)).save(ptask);
    }


    @Test
    public void findAllTest() {
        List<ParentTask> list = new ArrayList<ParentTask>();
        ParentTask taskOne = new ParentTask(1, "ParentTask1");
        ParentTask taskTwo = new ParentTask(2, "ParentTask2");
        ParentTask taskThree = new ParentTask(3, "ParentTask3");

        list.add(taskOne);
        list.add(taskTwo);
        list.add(taskThree);

        when(repo.findAll()).thenReturn(list);

        Iterable<ParentTask> taskList = service.getAllUsers();

        assertEquals(3, ((List<ParentTask>) taskList).size());
        verify(repo, times(1)).findAll();
    }


    @Test

    public void setParentIdTest() {
        ParentTask ptask = new ParentTask();
        ptask.setParentId(12);
    }

}
