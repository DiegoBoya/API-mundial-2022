package diego.worldcup.api.mundial22.service.dto.user;

import lombok.Data;

@Data
public class LoginUserRequest {
	private String email;
	private String password;

}
