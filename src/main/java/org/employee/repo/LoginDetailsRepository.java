package org.employee.repo;

import java.util.List;
import org.employee.entity.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface LoginDetailsRepository extends JpaRepository<LoginDetails, Integer> {

  List<LoginDetails> findByEmailAndPassword(String email, String password);
}
