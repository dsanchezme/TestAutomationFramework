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
import java.util.HashMap;

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

    public HttpResponse<String> createRequestToken(String apiKey, String apiReadAccessToken) throws URISyntaxException, IOException, InterruptedException {

        logger.debug("Creating a request token");

        String requestURL = "https://api.themoviedb.org/4/auth/request_token?api_key="+apiKey;

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Authorization", "Bearer "+apiReadAccessToken)
                .uri(new URI(requestURL))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public String getRequestToken(String apiKey, String apiReadAccessToken) throws URISyntaxException, IOException, InterruptedException {

        String createRequestTokenResponse = createRequestToken(apiKey, apiReadAccessToken).body();
        JsonObject responseAsJson = new Gson().fromJson(createRequestTokenResponse, JsonObject.class);

        logger.debug("Getting request token from response");

        try {
            return responseAsJson.get("request_token").getAsString();
        }catch (NullPointerException e){
            logger.error("Request token not found");
            return null;
        }
    }

    public HttpResponse<String> createAccessToken(String apiKey, String apiReadAccessToken, String requestToken) throws IOException, InterruptedException, URISyntaxException {
        logger.debug("Creating an access token");

        String requestURL = "https://api.themoviedb.org/4/auth/access_token?api_key="+apiKey;

        String requestBody = "{ \"request_token\": \"" + requestToken + "\" }";

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+apiReadAccessToken)
                .uri(new URI(requestURL))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public String getAccessToken(String apiKey, String apiReadAccessToken, String requestToken) throws URISyntaxException, IOException, InterruptedException {

        String createAccessTokenResponse = createAccessToken(apiKey, apiReadAccessToken, requestToken).body();
        JsonObject responseAsJson = new Gson().fromJson(createAccessTokenResponse, JsonObject.class);

        logger.debug("Getting access token from response");

        try {
            return responseAsJson.get("access_token").getAsString();
        }catch (NullPointerException e){
            logger.error("Access token not found");
            return null;
        }
    }
}
