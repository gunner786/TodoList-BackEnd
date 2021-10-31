package ie.ey.TodoList.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ie.ey.TodoList.entity.ToDoEntity;

@Repository
public interface ToDoRepository extends CrudRepository<ToDoEntity,Long>{

}
