package com.greenfoxacademy.restexercise.Repository;

import com.greenfoxacademy.restexercise.Model.Log;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends PagingAndSortingRepository<Log, Long> {
}
