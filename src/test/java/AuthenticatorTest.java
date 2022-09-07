import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@Feature("User authentication")
class AuthenticatorTest {

    @Test
    @Description("Verifying if a user is able to create a request token with a valid access token")
    public void createRequestTokenSuccess() throws URISyntaxException, IOException, InterruptedException {
        Authenticator authenticator = new Authenticator();

        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMTljNTFlZDQyMWZlMzUwMzEwNDViODMzOWI1ZmFkMyIsInN1YiI6IjYyZmNmZWQ1YjViYzIxMDA5MzEwOThmYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.3paYzYVdTalVxIxajErFCrZ-MQ_4i-m3P_bxEa7jTPU";

        int actualStatusCode = authenticator.createRequestToken(accessToken).statusCode();
        assertEquals(200, actualStatusCode);
    }

    @Test
    @Description("Verifying if a user is not able to create a request token with an invalid access token")
    public void createRequestTokenFailure() throws URISyntaxException, IOException, InterruptedException {
        Authenticator authenticator = new Authenticator();

        String accessToken = "invalidAccessToken";

        int actualStatusCode = authenticator.createRequestToken(accessToken).statusCode();
        assertEquals(401, actualStatusCode);
    }

    @Test
    @Description("Verifying if the request token can be accessed from create request token response made with a valid token")
    public void getRequestTokenSuccess() throws URISyntaxException, IOException, InterruptedException {
        Authenticator authenticator = new Authenticator();
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMTljNTFlZDQyMWZlMzUwMzEwNDViODMzOWI1ZmFkMyIsInN1YiI6IjYyZmNmZWQ1YjViYzIxMDA5MzEwOThmYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.3paYzYVdTalVxIxajErFCrZ-MQ_4i-m3P_bxEa7jTPU";

        String requestToken = authenticator.getRequestToken(accessToken);
        assertNotNull(requestToken);
    }

    @Test
    @Description("Verifying if the request token cannot be accessed from create request token response made with an invalid token")
    public void getRequestTokenFailure() throws URISyntaxException, IOException, InterruptedException {
        Authenticator authenticator = new Authenticator();
        String accessToken = "invalidAccessToken";

        String requestToken = authenticator.getRequestToken(accessToken);
        assertNull(requestToken);
    }
}