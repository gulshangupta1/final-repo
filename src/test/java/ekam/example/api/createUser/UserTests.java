package ekam.example.api.createUser;

import com.testvagrant.ekam.testBases.testng.APITest;
import ekam.example.api.getSingleUser.GetSingleUserResponse;
import ekam.example.api.login.LoginClient;
import ekam.example.api.login.LoginRequest;
import org.testng.annotations.Test;

import static com.testvagrant.ekam.commons.LayoutInitiator.Client;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class UserTests extends APITest {

    @Test(groups = "api", priority = 1)
    public void shouldReturnSingleUserTest() {
        int useID = 2;

        GetSingleUserResponse user = Client(UserClient.class)
                .getSingleUser(useID);
//        assertNotNull(user.getData().getEmail());
        System.out.println("Id: "+ user.getData().getId());
        System.out.println("First Name: "+ user.getData().getFirstName());
    }

    @Test(groups = "api", priority = 2)
    public void shouldCreateUser() {

        LoginRequest loginRequest = LoginRequest.builder()
                .email("eve.holt@reqres.in")
                .password("QpwL5tke4Pnpja7X4")
                .build();

        String token = Client(LoginClient.class)
                .login(loginRequest)
                .getToken();

        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .name("Bob")
                .job("Builder")
                .build();

        CreateUserResponse response = Client(UserClient.class)
                .createUser(createUserRequest, token);

        assertEquals(response.getName(), "Bob");

//        System.out.println("--------------------------------------");
//        System.out.println("Id: "+ response.getId());
//        System.out.println("First Name: "+ response.getName());
    }
}