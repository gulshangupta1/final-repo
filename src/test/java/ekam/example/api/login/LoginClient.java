package ekam.example.api.login;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testvagrant.ekam.api.retrofit.RetrofitBaseClient;
import retrofit2.Call;
import retrofit2.http.*;
import com.testvagrant.ekam.reports.annotations.APIStep;

public class LoginClient extends RetrofitBaseClient {

    private interface LoginService {
        @Headers({"Content-Type: application/json"})
        @POST("/api/login")
        Call<LoginResponse> login(@Body LoginRequest request);
    }

    private final LoginService service;

    @Inject
    public LoginClient(@Named("baseUrl") String baseUrl) {
        super(baseUrl);
        service = httpClient.getService(LoginService.class);
    }

    @APIStep(keyword = "When", description = "I invoke Login API")
    public LoginResponse login(LoginRequest request) {
        Call<LoginResponse> call = service.login(request);
        return httpClient.execute(call);
    }

}