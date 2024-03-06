package org.employee.service;

import org.common.ResponseCodes;
import org.employee.dto.SignUpRequest;
import org.employee.dto.SignUpResponse;
import org.employee.entity.PersonalDetails;
import org.employee.repo.PersonalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class SignUpServiceImpl implements SignUpService {
	@Autowired
	PersonalDetailsRepository personalDetailsRepo;

	@Autowired
	SignUpResponse signUpResponse;

	public SignUpResponse saveEmplyeesPersonalDetails(SignUpRequest signUpRequest) {

		PersonalDetails personalEntity = PersonalDetails.getInstance().setEmail(signUpRequest.getEmail())
				.setPassword(signUpRequest.getPassword());
		
		personalEntity = personalDetailsRepo.save(personalEntity);

		signUpResponse.setStatus(ResponseCodes.SIGN_UP_SUCCESS_CODE);
		signUpResponse.setMessage(ResponseCodes.SIGN_UP_SUCCESS_MESSAGE);

		return signUpResponse;

	}

}
