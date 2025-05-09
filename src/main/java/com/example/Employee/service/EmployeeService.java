package com.example.Employee.service;

import com.example.Employee.Entity.Employee;
import com.example.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository){
        this.repository = repository;
    }

    // get all employee
    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    // get employee by id
    public Employee getEmployeeById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not Found"));
    }

    // create new employee
    public Employee addEmployee(Employee employee){
        return repository.save(employee);
    }

    // update an employee detail
    public Employee updateEmployee(Long id, Employee employeeDetails){
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee no found"));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());

        return repository.save(employee);
    }

    public void deleteEmployee(Long id){
        repository.deleteById(id);
    }

}
