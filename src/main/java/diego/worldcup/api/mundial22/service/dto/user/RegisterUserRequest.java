package diego.worldcup.api.mundial22.service.dto.user;

import lombok.Data;

@Data
public class RegisterUserRequest {

	private String name;
	private String email;
	private String password;
	private String passwordConfirm;
}
