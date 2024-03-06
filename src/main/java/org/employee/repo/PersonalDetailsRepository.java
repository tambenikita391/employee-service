package org.employee.repo;

import java.util.List;

import org.employee.entity.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
@Component
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Integer>{

	List<PersonalDetails> findByEmailAndPassword(String email, String password);
}
