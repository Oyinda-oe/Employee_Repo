package com.example.Employee.Controller;

import com.example.Employee.Entity.Employee;
import com.example.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee") // base url route
public class EmployeeController {
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    // get all employees
    @GetMapping
    public List<Employee> getAllEmployees (){
        return service.getAllEmployees();
    }

    // get employee by id
    @GetMapping("/{id}")
    public Employee getEmployeesById(@PathVariable Long id){
        return service.getEmployeeById((id));
    }

    // create a new employee
    @PostMapping
    public Employee addEmployee( @RequestBody Employee employee){
        return service.addEmployee(employee);
    }

    // update employee details
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        return service.updateEmployee(id, employeeDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        return  "Employee deleted successfully";
    }
}
