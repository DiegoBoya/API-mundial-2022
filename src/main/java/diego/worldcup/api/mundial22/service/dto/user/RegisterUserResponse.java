package diego.worldcup.api.mundial22.service.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RegisterUserResponse {
	private String status;
	private String message;
	@JsonProperty("data")
	private AuthToken registerToken;

}
