package org.employee.controller;

import org.employee.dto.SignUpRequest;
import org.employee.dto.SignUpResponse;
import org.employee.service.SignUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

  @Autowired SignUpServiceImpl service;

  @PostMapping("/auth/sign")
  public SignUpResponse signUp(@RequestBody SignUpRequest request) {
    return service.saveEmplyeesPersonalDetails(request);
  }
}
