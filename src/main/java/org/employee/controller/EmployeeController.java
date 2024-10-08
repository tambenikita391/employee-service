package org.employee.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.employee.dto.EmployeeRequest;
import org.employee.dto.EmployeeResponse;
import org.employee.entity.Employee;
import org.employee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

  @Autowired EmployeeServiceImpl service;

  @PostMapping("/add/employee")
  public EmployeeResponse addEmployee(@Valid @RequestBody EmployeeRequest request) {
    return service.saveEmployeeDetails(request);
  }

  @PutMapping("/update/employee")
  public Employee update(@RequestBody Employee employee) {
    return service.updateEmployeeDetails(employee);
  }

  @GetMapping("/search/employee/{email}")
  public EmployeeResponse searchEmployee(@PathVariable String email) {
    return service.searchEmployee(email);
  }

  @GetMapping("/search/all/employee")
  public List<Employee> getAllEmployee() {
    return service.getAllEmployee();
  }

  @DeleteMapping("/delete/employee/{empId}")
  public String deleteEmp(@PathVariable int empId) {
    return service.deleteEmployee(empId);
  }
}
