package com.greenfoxacademy.jwtrestapi.repositories;

        import com.greenfoxacademy.jwtrestapi.models.Todo;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

        import java.util.ArrayList;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
  ArrayList<Todo> findTodosByAssignee_Username(String username);
}
