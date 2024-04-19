package org.employee.dto;

import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Component;

@Component
public class LoginRequest {

  @Pattern(regexp = "[a-zA-Z0-9{2,20}")
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
