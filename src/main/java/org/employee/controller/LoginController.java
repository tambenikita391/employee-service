package org.employee.controller;

import org.employee.dto.LoginRequest;
import org.employee.dto.LoginResponse;
import org.employee.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @Autowired LoginServiceImpl service;

  @PostMapping(path = "/auth/validate")
  public LoginResponse validate(@RequestBody LoginRequest request) {
    return service.validateEmployee(request);
  }
}
