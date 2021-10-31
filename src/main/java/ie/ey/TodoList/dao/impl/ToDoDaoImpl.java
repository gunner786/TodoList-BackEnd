package ie.ey.TodoList.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ie.ey.TodoList.dao.ToDoDao;
import ie.ey.TodoList.entity.ToDoEntity;
import ie.ey.TodoList.repository.ToDoRepository;

@Component
public class ToDoDaoImpl implements ToDoDao {
	
	@Autowired
	private ToDoRepository todoRepo;

	@Override
	public void saveToDo(ToDoEntity add_todo) {
		todoRepo.save(add_todo);
		
	}
	
	@Override
	public List<ToDoEntity> getAllTodo() {
		return (List<ToDoEntity>) todoRepo.findAll();
	}

	@Override
	public void deleteToDo(Long booking_id) {
		todoRepo.delete(booking_id);
	}

	@Override
	public ToDoEntity getToDo(Long booking_id) {
		return todoRepo.findOne(booking_id);	
	}

}
