package ekam.example.api.createUser;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequest{
	private String name;
	private String job;
}