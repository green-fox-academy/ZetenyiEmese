package com.greenfoxacademy.listingtodoswithassigneesmsql.repositories;

import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Assignee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
  Optional<Assignee> findAssigneeByName(String name);
}
