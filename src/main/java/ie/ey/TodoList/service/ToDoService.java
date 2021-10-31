package ie.ey.TodoList.service;

import java.util.List;

import ie.ey.TodoList.entity.ToDoEntity;
import ie.ey.TodoList.model.Task;


public interface ToDoService {
	
	void saveToDo(Task add_todo, boolean isEntityNew);
	List<ToDoEntity> getAllTodo();
	void deleteToDo(Long booking_id);
	ToDoEntity getToDo(Long booking_id);

}
