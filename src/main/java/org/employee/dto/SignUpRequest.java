package org.employee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Component;

@Component
public class SignUpRequest {

  @NotBlank(message = "Email cannot be blank")
  @Pattern(regexp = "[a-zA-Z0-9/_/-/.]+[@][a-z]+[/.][a-z]{3}")
  private String email;

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
