package org.employee.service;

import org.employee.dto.LoginRequest;
import org.employee.dto.LoginResponse;

public interface LoginService {
	public LoginResponse validateEmployee(LoginRequest request);

}
