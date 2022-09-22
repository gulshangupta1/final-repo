package ekam.example.api.gorest;

import com.testvagrant.ekam.testBases.testng.APITest;

import static com.testvagrant.ekam.commons.LayoutInitiator.*;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserTests extends APITest {

    @Test(groups = "api")
    public void shouldReturnSingleUserTest() {
        GetSingleUserResponse user = Client(UserClient.class).getSingleUser();

        assertNotNull(user.getEmail());
//        System.out.println(user.getName());
    }
}