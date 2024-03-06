package org.employee.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
@Component
public class SignUpRequest {
	
	@NotBlank(message = "Email cannot be blank")
	@Pattern(regexp = "[a-zA-Z0-9/_/-/.]+[@][a-z]+[/.][a-z]{3}")
	private String email;
	
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-z])(?=.*[@#$%]).{8,20}")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
