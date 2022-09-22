package ekam.example.api.createUser;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testvagrant.ekam.api.retrofit.RetrofitBaseClient;
import com.testvagrant.ekam.reports.annotations.APIStep;
import ekam.example.api.getSingleUser.GetSingleUserResponse;
import retrofit2.Call;
import retrofit2.http.*;
public class UserClient extends RetrofitBaseClient {

    private interface UserService {
        @GET("/api/users/{id}")
        Call<GetSingleUserResponse> getSingleUser(@Path("id") int useID);

        @Headers({"Content-Type: application/json"})
        @POST("/api/users")

        Call<CreateUserResponse> createUser(
                @Body CreateUserRequest request,
                @Header("authorization") String token
        );
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

    @APIStep(keyword = "When", description = "I invoke createUser API")
    public CreateUserResponse createUser(CreateUserRequest request, String token) {
            Call<CreateUserResponse> call = service.createUser(request, token);
        return httpClient.execute(call);
    }
}