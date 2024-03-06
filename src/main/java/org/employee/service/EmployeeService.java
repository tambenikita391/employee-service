package org.employee.service;

import java.util.List;

import org.employee.dto.EmployeeRequest;
import org.employee.dto.EmployeeResponse;
import org.employee.entity.Employee;

public interface EmployeeService {
	public EmployeeResponse saveEmployeeDetails(EmployeeRequest request);

	public Employee updateEmployeeDetails(Employee employee);
	
	public EmployeeResponse searchEmployee(String email);
	
	public List<Employee> getAllEmployee();
	
	public String deleteEmployee(int empId);



}
