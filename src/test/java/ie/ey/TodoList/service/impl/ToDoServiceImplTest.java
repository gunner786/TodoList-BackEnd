package ie.ey.TodoList.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ie.ey.TodoList.dao.ToDoDao;
import ie.ey.TodoList.model.Task;
import nl.altindag.log.LogCaptor;

@RunWith(SpringJUnit4ClassRunner.class)
public class ToDoServiceImplTest {
	
	@InjectMocks
	private ToDoServiceImpl todoServiceImpl;
	
	@Mock
	private ToDoDao toDoDao;
	
	private Task task;
	private LogCaptor logCaptor;
	private static final String logSaveMessage = "Saving Todo entity for task: Sample Task";
	private static final String logUpdateMessage = "Updating Todo Entity for taskId: 1";
	private static final String logGetAllMessage = "Getting all Todos";
	private static final String logDeleteMessage = "Deleting Todo for id: 5";
	private static final String logGetMessage = "Getting Todo for id: 5";
	
	
	@Before
	public void setUp() {
		logCaptor = LogCaptor.forClass(ToDoServiceImpl.class);
		task = new Task();
		task.setId(1l);
		task.setTaskDescription("Sample Description");
		task.setTaskName("Sample Task");
		
	}
	
	@Test
	public void testSaveToDo() {
		todoServiceImpl.saveToDo(task, true);
		assertThat(logCaptor.getInfoLogs()).containsExactly(logSaveMessage);
		verify(toDoDao,times(1)).saveToDo(any());
	}
	
	@Test
	public void testUpdateToDo() {
		todoServiceImpl.saveToDo(task, false);
		assertThat(logCaptor.getInfoLogs()).containsExactly(logUpdateMessage);
		verify(toDoDao,times(1)).saveToDo(any());
	}
	
	@Test
	public void testGetAllTodo() {
		todoServiceImpl.getAllTodo();
		assertThat(logCaptor.getInfoLogs()).containsExactly(logGetAllMessage);
		verify(toDoDao,times(1)).getAllTodo();		
	}
	
	@Test
	public void testDeleteToDo() {
		todoServiceImpl.deleteToDo(5L);
		assertThat(logCaptor.getInfoLogs()).containsExactly(logDeleteMessage);
		verify(toDoDao,times(1)).deleteToDo(5L);		
	}
	
	@Test
	public void testGetToDo() {
		todoServiceImpl.getToDo(5L);
		assertThat(logCaptor.getInfoLogs()).containsExactly(logGetMessage);
		verify(toDoDao,times(1)).getToDo(5L);		
	}
	
	

}
