package ekam.example.api.login;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginRequest{
	private String password;
	private String email;
}