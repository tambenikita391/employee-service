package org.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class LoginDetails {
  @Column @Id @GeneratedValue private int srNo;

  @Column private String email;

  @Column private String password;

  public static LoginDetails getInstance() {
    return new LoginDetails();
  }

  public int getSrNo() {
    return srNo;
  }

  public LoginDetails setSrNo(int srNo) {
    this.srNo = srNo;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public LoginDetails setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public LoginDetails setPassword(String password) {
    this.password = password;
    return this;
  }
}
