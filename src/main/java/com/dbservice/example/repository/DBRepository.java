package com.dbservice.example.repository;

import com.dbservice.example.model.Employee;
import com.dbservice.example.model.EmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBRepository extends ReactiveMongoRepository<Employee, String> {
}
