package ekam.example.api.gorest;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testvagrant.ekam.api.retrofit.RetrofitBaseClient;
import retrofit2.Call;
import retrofit2.http.*;
import com.testvagrant.ekam.reports.annotations.APIStep;

public class UserClient extends RetrofitBaseClient {

    private interface UserService {
        @GET("/public/v2/users/24")
        Call<GetSingleUserResponse> getSingleUser();
    }

    private final UserService service;

    @Inject
    public UserClient(@Named("baseUrl") String baseUrl) {
        super(baseUrl);
        service = httpClient.getService(UserService.class);
    }

    @APIStep(keyword = "When", description = "I invoke getSingleUser API")
    public GetSingleUserResponse getSingleUser() {
        Call<GetSingleUserResponse> call = service.getSingleUser();
        return httpClient.execute(call);
    }
}