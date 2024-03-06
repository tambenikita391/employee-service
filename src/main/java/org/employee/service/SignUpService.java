package org.employee.service;

import org.employee.dto.SignUpRequest;
import org.employee.dto.SignUpResponse;

public interface SignUpService {
	
	public SignUpResponse saveEmplyeesPersonalDetails(SignUpRequest signUpRequest);
	

}
