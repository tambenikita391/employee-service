package org.employee.service;

import java.util.List;
import java.util.Optional;

import org.common.ResponseCodes;
import org.employee.dto.EmployeeRequest;
import org.employee.dto.EmployeeResponse;
import org.employee.entity.Employee;
import org.employee.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;

	public EmployeeResponse saveEmployeeDetails(EmployeeRequest request) {
		EmployeeResponse response = new EmployeeResponse();

		Employee employee = new Employee();

		employee.setFullName(request.getFullName());
		employee.setPosition(request.getPosition());
		employee.setGender(request.getGender());
		employee.setSalary(request.getSalary());
		employee.setPhone(request.getPhone());
		employee.setAge(request.getAge());
		employee.seteMail(request.geteMail());

		employee = repo.save(employee);

		response.setCode(ResponseCodes.ADD_EMPLOYEE_SUCCESS_CODE);
		response.setMessage(ResponseCodes.ADD_EMPLOYEE_SUCCESS_MESSAGE);
		response.setEmpId(employee.getEmpId());
		return response;

	}

	public Employee updateDetails(Employee employee) {

		EmployeeResponse response = new EmployeeResponse();

		Employee updateEmployee = repo.findById(employee.getEmpId()).get();

		if (updateEmployee != null) {

			updateEmployee.setFullName(employee.getFullName());
			updateEmployee.setPosition(employee.getPosition());
			updateEmployee.setGender(employee.getGender());
			updateEmployee.setSalary(employee.getSalary());
			updateEmployee.setPhone(employee.getPhone());
			updateEmployee.setAge(employee.getAge());
			updateEmployee.seteMail(employee.geteMail());

			repo.save(updateEmployee);

			response.setCode(ResponseCodes.UPDATE_EMPLOYEE_SUCCESS_CODE);
			response.setMessage(ResponseCodes.UPDATE_EMPLOYEE_SUCCESS_MESSAGE);
			return updateEmployee;
		}
		response.setCode(ResponseCodes.UPDATE_EMPLOYEE_FAIL_CODE);
		response.setMessage(ResponseCodes.UPDATE_EMPLOYEE_FAIL_MESSAGE);;
		return null;

	}

	public EmployeeResponse searchEmployee(int empId) {
		EmployeeResponse response = new EmployeeResponse();
		Optional<Employee> empTable = repo.findById(empId);

		if (empTable.isEmpty()) {
			response.setCode(ResponseCodes.SEARCH_EMPLOYEE_FAIL_CODE);
			response.setMessage(ResponseCodes.SEARCH_EMPLOYEE_FAIL_MESSAGE);
		} else {
			Employee employee = empTable.get();

			response.setCode(ResponseCodes.SEARCH_EMPLOYEE_SUCCESS_CODE);
			response.setMessage(ResponseCodes.SEARCH_EMPLOYEE_SUCCESS_MESSAGE);
			response.setFullName(employee.getFullName());
			response.setPosition(employee.getPosition());
			response.setGender(employee.getGender());
			response.setSalary(employee.getSalary());
			response.setPhone(employee.getPhone());
			response.setAge(employee.getAge());
			response.seteMail(employee.geteMail());

		}
		return response;

	}

	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

	public String deleteEmployee(int empId) {
		repo.deleteById(empId);
		return "Employee deleted !!";
	}

}
