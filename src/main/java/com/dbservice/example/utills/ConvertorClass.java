package com.dbservice.example.utills;

import com.dbservice.example.model.Employee;
import com.dbservice.example.model.EmployeeResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Data
@Component
@AllArgsConstructor

public class ConvertorClass {

    /*@Autowired
    private EmployeeResponse employeeResponse;*/





    public  EmployeeResponse toEmployeeResponse(Employee employee){
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmpId(employee.getEmpId());
        employeeResponse.setName(employee.getName());
        employeeResponse.setOrganization(employee.getOrganization());
        return employeeResponse;
    }

}
