package com.greenfoxacademy.frontendjson.repositories;

import com.greenfoxacademy.frontendjson.models.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log, Long> {
}
