package com.dbservice.example.resource;

import com.dbservice.example.model.Employee;
import com.dbservice.example.model.EmployeeResponse;
import com.dbservice.example.service.DBServiceClass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/dbService")
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class DBServiceController {

    @Autowired
    private DBServiceClass dbService;

    @PostMapping("api/v6/saveEmployeeInfo")
    public Mono<EmployeeResponse> saveEmployee(@RequestBody Employee employee){
       return  this.dbService.addEmployee(employee);
    }

    @GetMapping("api/v6/getEmployeesInfo")
    public Flux<Employee> getEmployee(){
        return this.dbService.retrive();
    }

    @PutMapping("api/v6/updateEmp")
    public Mono<Employee> updateEmployee(@RequestBody Employee employee){

        return this.dbService.updateEmployee(employee);
    }

    @DeleteMapping("api/v6/delete/{id}")
    public Mono deleteEmployee(@PathVariable("id")  String id ){

        return this.dbService.deleteEmployee(id);
    }
}
