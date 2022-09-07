import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@Feature("User authentication")
class AuthenticatorTest {

    private final Dotenv dotenv = Dotenv.load();

    @Test
    @Description("Verifying if a user is able to create a request token with a valid API Read Access Token")
    public void createRequestTokenSuccess() throws URISyntaxException, IOException, InterruptedException {
        Authenticator authenticator = Authenticator.getInstance();

        String apiKey = dotenv.get("API_KEY");
        String apiReadAccessToken = dotenv.get("API_READ_ACCESS_TOKEN");

        int actualStatusCode = authenticator.createRequestToken(apiKey, apiReadAccessToken).statusCode();
        assertEquals(200, actualStatusCode);
    }

    @Test
    @Description("Verifying if a user is not able to create a request token with an invalid API Read Access Token")
    public void createRequestTokenFailure() throws URISyntaxException, IOException, InterruptedException {
        Authenticator authenticator = Authenticator.getInstance();

        String apiKey = dotenv.get("API_KEY");
        String apiReadAccessToken = "invalidApiReadAccessToken";

        int actualStatusCode = authenticator.createRequestToken(apiKey, apiReadAccessToken).statusCode();
        assertEquals(401, actualStatusCode);
    }

    @Test
    @Description("Verifying if the request token can be accessed from create request token response made with a valid API Read Access Token")
    public void getRequestTokenSuccess() throws URISyntaxException, IOException, InterruptedException {
        Authenticator authenticator = Authenticator.getInstance();

        String apiKey = dotenv.get("API_KEY");
        String apiReadAccessToken = dotenv.get("API_READ_ACCESS_TOKEN");

        String requestToken = authenticator.getRequestToken(apiKey, apiReadAccessToken);
        assertNotNull(requestToken);
    }

    @Test
    @Description("Verifying if the request token cannot be accessed from create request token response made with an invalid API Read Access Token")
    public void getRequestTokenFailure() throws URISyntaxException, IOException, InterruptedException {
        Authenticator authenticator = Authenticator.getInstance();

        String apiKey = dotenv.get("API_KEY");
        String apiReadAccessToken = "invalidAccessToken";

        String requestToken = authenticator.getRequestToken(apiKey, apiReadAccessToken);
        assertNull(requestToken);
    }
}