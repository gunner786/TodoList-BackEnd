package ie.ey.TodoList.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ie.ey.TodoList.entity.ToDoEntity;
import ie.ey.TodoList.model.Task;
import ie.ey.TodoList.service.ToDoService;

@RestController
@RequestMapping("/todos/v1")
public class TodoListController {
	
	private static final Logger logger = LoggerFactory.getLogger(TodoListController.class);
	
	@Autowired
	private ToDoService toDoService;
	
	@PostMapping(value = "/save")
	public void saveToDo(@RequestBody Task task) {
		logger.info("Saving todo in database");
		toDoService.saveToDo(task,true);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<ToDoEntity>> getToDo() {
		logger.info("Getting all todos from database");
		return ResponseEntity.ok(toDoService.getAllTodo());
	
	}
	
	@PostMapping(value = "/delete")
	public void deleteToDo(@RequestParam Long id) {
		logger.info("Deleting todo from database for id: {}", id);
		toDoService.deleteToDo(id);
	}
	
	@GetMapping(value = "/edit")
    public ResponseEntity<ToDoEntity> editToDo(@RequestParam Long id) {
		logger.info("Fetching todo for id: {}", id);
		return ResponseEntity.ok(toDoService.getToDo(id));	
    }
	
	@RequestMapping(value = "/update")
    public void updateToDo(@RequestBody Task task) {
		logger.info("Updating todo for id: {}", task.getId());
	 	toDoService.saveToDo(task,false);
    }

}
