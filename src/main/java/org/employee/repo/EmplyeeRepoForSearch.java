package org.employee.repo;

import java.util.List;

import org.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
@Component
public interface EmplyeeRepoForSearch extends JpaRepository<Employee, String>{
	
	List<Employee> findByEmail(String email);

}
