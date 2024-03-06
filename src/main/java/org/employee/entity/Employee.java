package org.employee.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
@Component
public class Employee {
	
	@Column
	@GeneratedValue
	@Id
	private int empId;
	
	@Column
	private String fullName;
	
	@Column
	private String position;
	
	@Column
	private String gender;
	
	@Column
	private String salary;
	
	@Column
	private String phone;
	
	@Column
	private String age;
	
	@Column
	private String email;
	
	public static Employee getInstance() {
		return new Employee();
	}

	public int getEmpId() {
		return empId;
	}

	public Employee setEmpId(int empId) {
		this.empId = empId;
		return this;
	}

	public String getFullName() {
		return fullName;
	}

	public Employee setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public Employee setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getSalary() {
		return salary;
	}

	public Employee setSalary(String salary) {
		this.salary = salary;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public Employee setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getPosition() {
		return position;
	}

	public Employee setPosition(String position) {
		this.position = position;
		return this;
	}

	public String getAge() {
		return age;
	}

	public Employee setAge(String age) {
		this.age = age;
		return this;
	}

	public String geteMail() {
		return email;
	}

	public Employee seteMail(String eMail) {
		this.email = eMail;
		return this;
	}
	
	

}
