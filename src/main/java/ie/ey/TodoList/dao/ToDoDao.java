package ie.ey.TodoList.dao;

import java.util.List;

import ie.ey.TodoList.entity.ToDoEntity;

public interface ToDoDao {
	
	void saveToDo(ToDoEntity add_todo);

	List<ToDoEntity> getAllTodo();

	void deleteToDo(Long booking_id);

	ToDoEntity getToDo(Long booking_id);

}
