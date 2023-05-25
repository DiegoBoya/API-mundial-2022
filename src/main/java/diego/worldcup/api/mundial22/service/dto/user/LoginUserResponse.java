package diego.worldcup.api.mundial22.service.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginUserResponse {
	private String status;
	@JsonProperty("data")
	private AuthToken authToken;
}
