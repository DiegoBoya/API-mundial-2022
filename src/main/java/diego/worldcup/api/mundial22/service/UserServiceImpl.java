package diego.worldcup.api.mundial22.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import diego.worldcup.api.mundial22.service.dto.user.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl extends BaseService implements UserService {

	@Override
	public RegisterUserResponse registerUser(RegisterUserRequest req) {
		String URL = super.baseUrl + "/user";
		log.info("Sending the info to create the user {}", req);
		ResponseEntity<RegisterUserResponse> response ;
		try {

			response = super.restTemplate.postForEntity(URL, req,
					RegisterUserResponse.class);
			log.info("volvio-------------------------");
			if (response.getStatusCode().is2xxSuccessful()) {
				log.info("User has been created succesfuly: {}", response.getBody().getStatus());
				return response.getBody();
			}
		} catch (Exception e) {
			log.error("Error creating user. Cause: " + e.getCause());
			log.error(e.getMessage());
//			throw new RuntimeException(errorMessage);
		}
		return null;

	}

	@Override
	public LoginUserResponse loginUser(LoginUserRequest req) {
		String URL = super.baseUrl + "/login";
		log.info("The user {} is trying to login", req.getEmail());

		ResponseEntity<LoginUserResponse> response = super.restTemplate.postForEntity(URL, req,
				LoginUserResponse.class);

		if (response.getStatusCode().is2xxSuccessful()) {
			log.info("User {} succesfully loged in", req.getEmail());
			return response.getBody();
		}

		String errorMessage = "Error during the login, if the error persist call the admin";
		log.error(errorMessage);
		throw new RuntimeException(errorMessage);
	}

}
