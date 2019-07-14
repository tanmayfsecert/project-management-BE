package com.fsd.cts.projectmanagement.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.fsd.cts.projectmanagement.dao.ParentTask;
import com.fsd.cts.projectmanagement.dao.Project;
import com.fsd.cts.projectmanagement.dao.Task;
import com.fsd.cts.projectmanagement.dao.User;
import com.fsd.cts.projectmanagement.model.TaskObj;
import com.fsd.cts.projectmanagement.repository.ParentTaskRepository;
import com.fsd.cts.projectmanagement.repository.ProjectRepository;
import com.fsd.cts.projectmanagement.repository.TaskRepository;
import com.fsd.cts.projectmanagement.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TaskServiceTest {

	@InjectMocks
	private TaskService taskService;

	@Mock
	private TaskRepository taskRepo;

	@Mock
	private ParentTaskRepository parentRepo;

	@Mock
	private UserRepository userRepo;
	@Mock
	private ProjectRepository projectRepo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void validate() {
		validateMockitoUsage();
	}

	@Test
	public void updateTaskTest() throws ParseException {

		/*
		 * public Task updateTask(TaskObj task) { Task t =
		 * taskRepo.findByID(task.getTaskId()); t.setParentId(task.getParentTaskId());
		 * t.setProjectId(task.getProjectId()); t.setTask(task.getTaskName());
		 * t.setStartDate(task.getStartDate()); t.setEndDate(task.getEndDate());
		 * t.setPriority(task.getPriority()); t.setStatus(task.getStatus()); return
		 * taskRepo.save(t); }
		 */
		Task t = new Task();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String startDate = "15-10-2015";
		Date dateOne = sdf.parse(startDate);

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		String endDate = "15-10-2015";
		Date dateTwo = sdf.parse(startDate);
		// Integer taskId, Integer parentId, Integer projectId, String task, Date
		// startDate, Date endDate,
		// Integer priority, String status, Integer userId
		Task temp = new Task(1, 12, 45, "taskName",
						dateOne, dateTwo, 1, "STARTED", 45);
		// null pointer exception

		when(taskRepo.findById(123)).thenReturn(Optional.of(temp));
		t.setParentId(temp.getParentId());
		t.setTask(temp.getTask());
		t.setStartDate(temp.getStartDate());
		t.setEndDate(temp.getEndDate());
		t.setPriority(temp.getPriority());
		t.setStatus(temp.getStatus());
		taskRepo.save(t);
	}

	@Test
	public void getTasksByProjectTest() throws ParseException {
//    	Integer taskId, String taskName, boolean parentTask, String projectName, Date startDate,
//		Date endDate, String parentTaskName, Integer parentTaskId, Integer projectId, String userName,
//		Integer userId, Integer priority, String status
//    	

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String startDate = "15-10-2015";
		Date dateOne = sdf.parse(startDate);

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		String endDate = "15-10-2015";
		Date dateTwo = sdf.parse(startDate);

		// List<Task> taskObjList = new ArrayList<>();
		List<Task> taskList = new ArrayList<>();
		when(taskRepo.findAllByProjectId(1)).thenReturn(taskList);

		// List<TaskObj> taskObjList = new ArrayList<>();
		// List<Task> taskList = taskRepo.findAllByProjectId(id);

		// TaskObj obj = new
		// TaskObj(1,"taskName",true,"projectName",dateOne,dateTwo,"parentTaskName",1,12,"shona",122,5,"STARTED");
		// ((ArrayList<TaskObj>) taskObjList).add(obj);
		// when(((TaskService) taskRepo).getTasksByProject(1)).thenReturn(taskObjList);
		// List<TaskObj> taskObjList1 = new ArrayList<>();

		// taskObjList1 = (List<TaskObj>) taskService.getTasksByProject(1);
		// assertsEquals(1,obj.getTaskId());
		// assertsEquals("taskName",obj.getTaskName());

	}

	@Test
	public void addNewTaskTest() throws ParseException

	{

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String startDate = "15-10-2015";
		Date dateOne = sdf.parse(startDate);

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		String endDate = "15-10-2015";
		Date dateTwo = sdf.parse(startDate);

		// Integer taskId, Integer parentId, Integer projectId, String task, Date
		// startDate, Date endDate,
		// Integer priority, String status, Integer userId

		TaskObj task = new TaskObj();

		Task t = new Task(12, 89, 78, "task", dateOne, dateTwo, 1, "STARTED", 12);
		taskService.addNewTask(task);

		// taskRepo.save(t);

		// verify(taskRepo, times(0)).addNewTask(t);

		/*
		 * Task t = new Task(); t.setParentId(task.getParentTaskId());
		 * t.setProjectId(task.getProjectId()); t.setTask(task.getTaskName());
		 * t.setStartDate(task.getStartDate()); t.setEndDate(task.getEndDate());
		 * t.setPriority(task.getPriority()); t.setUserId(task.getUserId());
		 * t.setStatus("STARTED"); taskRepo.save(t);
		 */
	}

	@Test
	public void addNewTaskTest2() {
		/*
		 * ParentTask pTask = new ParentTask(); pTask.setParentTask(task.getTaskName());
		 * repo.save(pTask);
		 */

		ParentTask pTask = new ParentTask();
		pTask.setParentTask("task");
		TaskObj task = new TaskObj();
		taskService.addNewTask(task);

	}

	@Test

	public void settersGetters() throws ParseException {
		Task t = new Task();
		t.setProjectId(12);
		t.getProjectId();
		t.setTaskId(78);
		t.getTaskId();
		t.setUserId(45);
		t.getUserId();
		TaskObj obj = new TaskObj();
		obj.setTaskId(12);
		obj.getTaskId();
		obj.setTaskName("sjkj");
		obj.getTaskName();
		obj.setProjectId(12);
		obj.getProjectId();
		obj.setTaskId(78);
		obj.getTaskId();
		obj.setUserId(45);
		obj.getUserId();
		obj.setParentTask(false);
		obj.getParentTaskId();
		obj.setProjectName("tanm");
		obj.getProjectName();
		obj.setParentTaskName("tanm");
		obj.getParentTaskName();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String startDate = "15-10-2015";
		Date dateOne = sdf.parse(startDate);

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		String endDate = "15-10-2015";
		Date dateTwo = sdf.parse(startDate);
		
		TaskObj task = new TaskObj(12, "taskName", true, "projectName", dateOne,
				dateTwo,"parentTaskName",12, 78, "userName",
				45,2,"started");

		obj.setEndDate(dateTwo);
		obj.getEndDate();
		obj.setStartDate(dateOne);
		obj.getStartDate();

		obj.setPriority(1);
		obj.getPriority();
		obj.setStatus("stat");
		obj.getStatus();

		obj.setParentTaskId(4);
		obj.setUserName("tanm");
		obj.getParentTaskId();
		obj.getUserName();
		

	}

	@Test

	public void getAllTasksTest() throws ParseException {
		Iterable<TaskObj> taskObjList = new ArrayList<>();
		List<Task> taskList = (List<Task>) new ArrayList<Task>();
		TaskObj obj = new TaskObj();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String startDate = "15-10-2015";
		Date dateOne = sdf.parse(startDate);

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		String endDate = "15-10-2015";
		Date dateTwo = sdf.parse(startDate);

		Task t = new Task(12, 89, 78, "task", dateOne, dateTwo, 1, "STARTED", 12);

		obj.setTaskId(t.getTaskId());
		// obj.setParentId(t.getParentId());
		obj.setProjectId(t.getProjectId());
		// obj.setTask(t.getTask());
		obj.setStartDate(t.getStartDate());
		obj.setEndDate(t.getEndDate());
		obj.setPriority(t.getPriority());
		obj.setStatus(t.getStatus());
		obj.setUserId(t.getUserId());

		if (t.getParentId() != null) {

			ParentTask pTask = new ParentTask(1, "ParentTask1");
			when(parentRepo.findById(1)).thenReturn(Optional.of(pTask));
			// ParentTask pTask = parentRepo.findByID(t.getParentId());
			if (pTask != null) {
				obj.setParentTaskName(pTask.getParentTask());
			}
		}
		if (t.getProjectId() != null) {
			SimpleDateFormat sdf12 = new SimpleDateFormat("dd-M-yyyy");
			String startDate1 = "15-10-2015";
			Date dateOne1 = sdf.parse(startDate);

			SimpleDateFormat sdf11 = new SimpleDateFormat("dd-M-yyyy");
			String endDate1 = "15-10-2015";
			Date dateTwo1 = sdf.parse(startDate);

			Project project = new Project(1, "project", dateOne, dateTwo, 1, 123);
			when(projectRepo.findById(1)).thenReturn(Optional.of(project));
			if (project != null) {
				obj.setProjectName(project.getProject());
			}
		}

		if (t.getUserId() != null) {
			User user = new User(1, "tanmay", "patra", "727496");
			when(userRepo.findById(1)).thenReturn(Optional.of(user));
			if (user != null) {
				obj.setUserName(user.getFirstName());
			}

			((ArrayList<TaskObj>) taskObjList).add(obj);
			when(taskRepo.findAll()).thenReturn(taskList);

		}

		/*
		 * List<TaskObj> taskObjList = new ArrayList<>(); List<Task> taskList =
		 * (List<Task>) taskRepo.findAll(); for(Task t: taskList){ TaskObj obj = new
		 * TaskObj(); obj.setTaskId(t.getTaskId());
		 * obj.setParentTaskId(t.getParentId()); obj.setProjectId(t.getProjectId());
		 * obj.setTaskName(t.getTask()); obj.setStartDate(t.getStartDate());
		 * obj.setEndDate(t.getEndDate()); obj.setPriority(t.getPriority());
		 * obj.setStatus(t.getStatus()); obj.setUserId(t.getUserId());
		 * if(t.getParentId() != null){ ParentTask pTask =
		 * repo.findByID(t.getParentId()); if(pTask != null){
		 * obj.setParentTaskName(pTask.getParentTask()); } } if(t.getProjectId() !=
		 * null){ Project p = projectRepo.findByID(t.getProjectId()); if(p != null){
		 * obj.setProjectName(p.getProject()); } } if(t.getUserId() != null){ User u =
		 * userRepo.findByID(t.getUserId()); if(u != null){
		 * obj.setUserName(u.getFirstName()); } }
		 * 
		 * taskObjList.add(obj);
		 * 
		 * }
		 * 
		 * return taskObjList;
		 */

	}
}
