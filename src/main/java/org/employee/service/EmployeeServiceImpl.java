package org.employee.service;

import java.util.List;
import org.common.ResponseCodes;
import org.employee.dto.EmployeeRequest;
import org.employee.dto.EmployeeResponse;
import org.employee.entity.Employee;
import org.employee.repo.EmployeeRepository;
import org.employee.repo.EmplyeeRepoForSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired EmployeeRepository employeeRepo;

  @Autowired EmployeeResponse employeeResponse;

  @Autowired EmplyeeRepoForSearch employeeRepoForSearch;

  public EmployeeResponse saveEmployeeDetails(EmployeeRequest request) {

    if (employeeRepo.existsByEmail(request.geteMail())) {
      employeeResponse.setCode(ResponseCodes.EXISTING_EMAIL_CODE);
      employeeResponse.setMessage(ResponseCodes.EXISTING_EMAIL_MESSAGE);
    }
    Employee employee =
        Employee.getInstance()
            .setFullName(request.getFullName())
            .setPosition(request.getPosition())
            .setGender(request.getGender())
            .setSalary(request.getSalary())
            .setPhone(request.getPhone())
            .setAge(request.getAge())
            .seteMail(request.geteMail());

    try {
      employee = employeeRepo.save(employee);
    } catch (Exception e) {
      e.printStackTrace();
    }

    employeeResponse.setCode(ResponseCodes.ADD_EMPLOYEE_SUCCESS_CODE);
    employeeResponse.setMessage(ResponseCodes.ADD_EMPLOYEE_SUCCESS_MESSAGE);
    employeeResponse.setEmpId(employee.getEmpId());
    return employeeResponse;
  }

  public Employee updateEmployeeDetails(Employee employee) {

    Employee updateEmployee = employeeRepo.findById(employee.getEmpId()).get();

    if (updateEmployee != null) {

      updateEmployee.setFullName(employee.getFullName());
      updateEmployee.setPosition(employee.getPosition());
      updateEmployee.setGender(employee.getGender());
      updateEmployee.setSalary(employee.getSalary());
      updateEmployee.setPhone(employee.getPhone());
      updateEmployee.setAge(employee.getAge());
      updateEmployee.seteMail(employee.geteMail());

      employeeRepo.save(updateEmployee);

      employeeResponse.setCode(ResponseCodes.UPDATE_EMPLOYEE_SUCCESS_CODE);
      employeeResponse.setMessage(ResponseCodes.UPDATE_EMPLOYEE_SUCCESS_MESSAGE);
      return updateEmployee;
    }
    employeeResponse.setCode(ResponseCodes.UPDATE_EMPLOYEE_FAIL_CODE);
    employeeResponse.setMessage(ResponseCodes.UPDATE_EMPLOYEE_FAIL_MESSAGE);
    ;
    return null;
  }

  public EmployeeResponse searchEmployee(String email) {
    List<Employee> empTable = employeeRepoForSearch.findByEmail(email);

    if (empTable.isEmpty()) {
      employeeResponse.setCode(ResponseCodes.SEARCH_EMPLOYEE_FAIL_CODE);
      employeeResponse.setMessage(ResponseCodes.SEARCH_EMPLOYEE_FAIL_MESSAGE);
    } else {
      Employee employee = empTable.get(0);

      employeeResponse.setCode(ResponseCodes.SEARCH_EMPLOYEE_SUCCESS_CODE);
      employeeResponse.setMessage(ResponseCodes.SEARCH_EMPLOYEE_SUCCESS_MESSAGE);
      employeeResponse.setFullName(employee.getFullName());
      employeeResponse.setPosition(employee.getPosition());
      employeeResponse.setGender(employee.getGender());
      employeeResponse.setSalary(employee.getSalary());
      employeeResponse.setPhone(employee.getPhone());
      employeeResponse.setAge(employee.getAge());
      employeeResponse.seteMail(employee.geteMail());
    }
    return employeeResponse;
  }

  public List<Employee> getAllEmployee() {
    return employeeRepo.findAll();
  }

  public String deleteEmployee(int empId) {
    employeeRepo.deleteById(empId);
    return "Employee deleted !!";
  }
}
