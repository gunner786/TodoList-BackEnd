package ie.ey.TodoList.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;

import ie.ey.TodoList.dao.ToDoDao;
import ie.ey.TodoList.entity.ToDoEntity;
import ie.ey.TodoList.model.Task;
import ie.ey.TodoList.service.ToDoService;

@Component
public class ToDoServiceImpl implements ToDoService {

	private static final Logger logger = LoggerFactory.getLogger(ToDoServiceImpl.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	
	@Autowired
	ToDoDao toDoDao;
	
	@Override
	public void saveToDo(Task addTodo, boolean isEntityNew) {
		ToDoEntity toDoEntity = new ToDoEntity();
		toDoEntity.setTaskName(addTodo.getTaskName());
		toDoEntity.setTaskDescription(addTodo.getTaskDescription());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		toDoEntity.setLastUpdated(sdf.format(timestamp));
		if(!isEntityNew) {
			logger.info("Updating Todo Entity for taskId: {}", addTodo.getId());
			toDoEntity.setId(addTodo.getId());
		}else {
			logger.info("Saving Todo entity for task: {}", addTodo.getTaskName());
		}
		toDoDao.saveToDo(toDoEntity);
		
	}

	@Override
	public List<ToDoEntity> getAllTodo() {
		logger.info("Getting all Todos");
		return toDoDao.getAllTodo();
	}

	@Override
	public void deleteToDo(Long id) {
		logger.info("Deleting Todo for id: {}",id);
		toDoDao.deleteToDo(id);
		
	}

	@Override
	public ToDoEntity getToDo(Long id) {
		logger.info("Getting Todo for id: {}",id);
		return toDoDao.getToDo(id);
	}

}
