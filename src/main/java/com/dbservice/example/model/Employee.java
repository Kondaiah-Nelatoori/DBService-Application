package com.dbservice.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "EmployeeInfo")
public class Employee {

    @Id
    private String empId;
    private String name;
    private Address address;
    private Salary salary;
    private Organization organization;
    private List<Project> projectsList;
}