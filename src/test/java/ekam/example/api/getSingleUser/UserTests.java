package ekam.example.api.getSingleUser;

import com.testvagrant.ekam.testBases.testng.APITest;
import static com.testvagrant.ekam.commons.LayoutInitiator.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class UserTests extends APITest {

    @Test(groups = "api")
    public void shouldReturnSingleUserTest() {
        int useID = 2;

        GetSingleUserResponse user = Client(UserClient.class)
                .getSingleUser(useID);
        assertNotNull(user.getData().getEmail());
        System.out.println("First Name: "+ user.getData().getFirstName());
    }
}