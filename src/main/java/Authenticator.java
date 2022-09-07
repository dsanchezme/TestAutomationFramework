import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Authenticator {

    private static Authenticator uniqueInstance;
    private final Logger logger = LogManager.getLogger(Main.class);

    private Authenticator(){}

    public static Authenticator getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Authenticator();
        }
        return uniqueInstance;
    }

    public HttpResponse<String> createRequestToken(String accessToken) throws URISyntaxException, IOException, InterruptedException {

        logger.debug("Creating a request token");

        String requestURL = "https://api.themoviedb.org/4/auth/request_token";

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Authorization", "Bearer "+accessToken)
                .uri(new URI(requestURL))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public String getRequestToken(String accessToken) throws URISyntaxException, IOException, InterruptedException {

        String createRequestTokenResponse = createRequestToken(accessToken).body();
        JsonObject responseAsJson = new Gson().fromJson(createRequestTokenResponse, JsonObject.class);

        logger.debug("Getting request token from response");

        try {
            return responseAsJson.get("request_token").getAsString();
        }catch (NullPointerException e){
            logger.error("Request token not found");
            return null;
        }

    }
}
