package org.employee.repo;

import java.util.List;
import java.util.Optional;

import org.employee.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.email_id = :email_id")
	boolean existsByEmail_id(@Param("email_id") String email_id);

	Optional<Customer> findByMobile(String mobile);

	//List<Customer> findByUserId(Long id);

	@Query("SELECT c FROM Customer c WHERE c.customer_id = :customer_id")
	List<Customer> findByCustomer_id(@Param("customer_id") Long customerId);
	
	

}
