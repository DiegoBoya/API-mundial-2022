package diego.worldcup.api.mundial22.controller;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diego.worldcup.api.mundial22.service.UserService;
import diego.worldcup.api.mundial22.service.dto.user.*;


@RestController
@RequestMapping("worldcup/users")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class.getName());
	
	// diego: raro que no hace un autowired
	private final UserService userService;

	// raro que usa el constructor
	public UserController(UserService us) {
		this.userService = us;
	}

	@PostMapping("/register")
	public RegisterUserResponse registerUser(@RequestBody RegisterUserRequest userData) {
		logger.info("se procede a registrar al usuario " + userData.getEmail());		
		RegisterUserResponse response = this.userService.registerUser(userData);
		logger.info("------------------------------------" + response);
		return response;
	}
	
	@PostMapping("/login")
	public LoginUserResponse loginUser(@RequestBody LoginUserRequest userData) {
		logger.info("El usuario " + userData.getEmail() + " realiza el login.");	
		return this.userService.loginUser(userData);
	}
}
