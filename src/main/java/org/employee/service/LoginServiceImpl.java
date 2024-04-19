package org.employee.service;

import java.util.List;
import org.common.ResponseCodes;
import org.employee.dto.LoginRequest;
import org.employee.dto.LoginResponse;
import org.employee.entity.LoginDetails;
import org.employee.repo.LoginDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class LoginServiceImpl implements LoginService {

  @Autowired LoginDetailsRepository personalDetailsRepo;

  @Autowired LoginResponse loginResponse;

  public LoginResponse validateEmployee(LoginRequest request) {

    List<LoginDetails> receivedData =
        personalDetailsRepo.findByEmailAndPassword(request.getEmail(), request.getPassword());
    if (receivedData.size() == 1) {
      loginResponse.setStatus(ResponseCodes.LOGIN_SUCCESS_CODE);
      loginResponse.setMessage(ResponseCodes.LOGIN_SUCCESS_MESSAGE);
    } else {
      loginResponse.setStatus(ResponseCodes.LOGIN_FAIL_CODE);
      loginResponse.setMessage(ResponseCodes.LOGIN_FAIL_MESSAGE);
    }
    return loginResponse;
  }
}
