package ekam.example.api.getSingleUser;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Data{
	@SerializedName("last_name")
	private String lastName;
	private int id;
	private String avatar;
	@SerializedName("first_name")
	private String firstName;
	private String email;
}