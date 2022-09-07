import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@Epic("User authentication")
@Feature("This is a feature")
class AuthTest {

    @Test
    @Story("As a user I want to create a request token with a valid access token")
    @Description("This is a description for the test created")
    public void createRequestTokenSuccess() throws URISyntaxException, IOException, InterruptedException {
        Auth auth = new Auth();

        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMTljNTFlZDQyMWZlMzUwMzEwNDViODMzOWI1ZmFkMyIsInN1YiI6IjYyZmNmZWQ1YjViYzIxMDA5MzEwOThmYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.3paYzYVdTalVxIxajErFCrZ-MQ_4i-m3P_bxEa7jTPU";

        int actualStatusCode = auth.createRequestToken(accessToken).statusCode();
        assertEquals(200, actualStatusCode);
    }

    @Test
    @Story("As a user I want to create a request token")
    @Description("This is a description for the test created")
    public void createRequestTokenFailure() throws URISyntaxException, IOException, InterruptedException {
        Auth auth = new Auth();

        String accessToken = "invalidAccessToken";

        int actualStatusCode = auth.createRequestToken(accessToken).statusCode();
        assertEquals(401, actualStatusCode);
    }

    @Test
    public void getRequestTokenSuccess() throws URISyntaxException, IOException, InterruptedException {
        Auth auth = new Auth();
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMTljNTFlZDQyMWZlMzUwMzEwNDViODMzOWI1ZmFkMyIsInN1YiI6IjYyZmNmZWQ1YjViYzIxMDA5MzEwOThmYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.3paYzYVdTalVxIxajErFCrZ-MQ_4i-m3P_bxEa7jTPU";

        String requestToken = auth.getRequestToken(accessToken);
        assertNotNull(requestToken);
    }

    @Test
    public void getRequestTokenFailure() throws URISyntaxException, IOException, InterruptedException {
        Auth auth = new Auth();
        String accessToken = "invalidAccessToken";

        String requestToken = auth.getRequestToken(accessToken);
        assertNull(requestToken);
    }
}