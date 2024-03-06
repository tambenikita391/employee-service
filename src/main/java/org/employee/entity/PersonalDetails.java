package org.employee.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@Component
public class PersonalDetails {
	@Column
	@Id
	@GeneratedValue
	private int srNo;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	public static PersonalDetails getInstance() {
		return new PersonalDetails();
	}

	public int getSrNo() {
		return srNo;
	}

	public PersonalDetails setSrNo(int srNo) {
		this.srNo = srNo;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public PersonalDetails setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public PersonalDetails setPassword(String password) {
		this.password = password;
		return this;
	}
	

}
