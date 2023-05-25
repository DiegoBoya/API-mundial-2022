package diego.worldcup.api.mundial22.service;
import diego.worldcup.api.mundial22.service.dto.user.*;


public interface UserService {
	
	public RegisterUserResponse registerUser(RegisterUserRequest req);
	public LoginUserResponse loginUser(LoginUserRequest req);

}
