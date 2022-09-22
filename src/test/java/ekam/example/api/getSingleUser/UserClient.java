package ekam.example.api.getSingleUser;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testvagrant.ekam.api.retrofit.RetrofitBaseClient;
import retrofit2.Call;
import retrofit2.http.*;
import com.testvagrant.ekam.reports.annotations.APIStep;

public class UserClient extends RetrofitBaseClient {

    private interface UserService {
        @GET("/api/users/{id}")
        Call<GetSingleUserResponse> getSingleUser(@Path("id") int useID);
    }

    private final UserService service;

    @Inject
    public UserClient(@Named("baseUrl") String baseUrl) {
        super(baseUrl);
        service = httpClient.getService(UserService.class);
    }

    @APIStep(keyword = "When", description = "I invoke getSingleUser API")
    public GetSingleUserResponse getSingleUser(int useID) {
            Call<GetSingleUserResponse> call = service.getSingleUser(useID);
        return httpClient.execute(call);
    }

}