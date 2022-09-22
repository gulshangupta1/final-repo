package ekam.example.api.gorest;

import lombok.Getter;

@Getter
public class GetSingleUserResponse {
	private int id;
	private String name;
	private String email;
	private String gender;
	private String status;
}