package com.greenfoxacademy.restexercise.Repository;

import com.greenfoxacademy.restexercise.Model.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log, Long> {
}
