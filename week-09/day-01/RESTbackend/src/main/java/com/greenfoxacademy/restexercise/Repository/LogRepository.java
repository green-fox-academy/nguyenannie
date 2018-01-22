package com.greenfoxacademy.restexercise.Repository;

import com.greenfoxacademy.restexercise.Model.LogEndpoint.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends PagingAndSortingRepository<Log, Long> {
}
