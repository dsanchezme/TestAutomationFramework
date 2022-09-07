import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final Dotenv dotenv = Dotenv.load();
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        Configurator.setLevel(logger.getName(), Level.DEBUG);

        Authenticator authenticator = Authenticator.getInstance();

        String apiKey = dotenv.get("API_KEY");
        String apiReadAccessToken = dotenv.get("API_READ_ACCESS_TOKEN");

        String requestToken = authenticator.getRequestToken(apiKey, apiReadAccessToken);
        logger.info("Request Token: "+requestToken);


    }
}
