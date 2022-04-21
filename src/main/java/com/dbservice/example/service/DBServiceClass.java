package com.dbservice.example.service;

import com.dbservice.example.model.Employee;
import com.dbservice.example.model.EmployeeResponse;
import com.dbservice.example.repository.DBRepository;
import com.dbservice.example.utills.ConvertorClass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class DBServiceClass {

    @Autowired
    private DBRepository repository;

    @Autowired
    private ConvertorClass convertorClass;


    public Mono<EmployeeResponse> addEmployee(Employee employee) {
       Mono<Employee> employee1 = this.repository.save(employee);
     return employee1.map(monoEmp -> convertorClass.toEmployeeResponse(monoEmp));
    }

    public Flux<Employee> retrive() {
        return this.repository.findAll();
    }

    public Mono<Employee> updateEmployee(final Employee employee) {
       return this.repository.findById(employee.getEmpId())
                .flatMap(repository :: save) ;
    }

    public Mono deleteEmployee(final String id) {
       return this.repository.deleteById(id).thenEmpty(Mono.empty());
    }
}
