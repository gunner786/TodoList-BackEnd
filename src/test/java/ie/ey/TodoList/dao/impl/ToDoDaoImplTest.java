package ie.ey.TodoList.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyCollection;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ie.ey.TodoList.entity.ToDoEntity;
import ie.ey.TodoList.repository.ToDoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class ToDoDaoImplTest {
	
	@InjectMocks
	private ToDoDaoImpl daoImpl;
	
	@Mock
	private ToDoRepository todoRepo;
	
	private ToDoEntity toDoEntity;
	
	@Before
	public void setUp() {
		toDoEntity = new ToDoEntity();
		toDoEntity.setId(1L);
		toDoEntity.setTaskDescription("Desc");
		toDoEntity.setTaskName("Name");
	}
	
	@Test
	public void testSaveToDo() {
		daoImpl.saveToDo(toDoEntity);
		verify(todoRepo, times(1)).save(toDoEntity);	
	}
	
	@Test
	public void testGetAllTodo() {
		daoImpl.getAllTodo();
		verify(todoRepo, times(1)).findAll();
	}
	
	@Test
	public void testDeleteToDo() {
		daoImpl.deleteToDo(5L);
		verify(todoRepo, times(1)).delete(5L);
	}
	
	@Test
	public void testGetToDo() {
		daoImpl.getToDo(5L);
		verify(todoRepo, times(1)).findOne(5L);
	}
	
	

}
