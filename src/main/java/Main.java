import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        Configurator.setLevel(logger.getName(), Level.DEBUG);

        Authenticator authenticator = new Authenticator();
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMTljNTFlZDQyMWZlMzUwMzEwNDViODMzOWI1ZmFkMyIsInN1YiI6IjYyZmNmZWQ1YjViYzIxMDA5MzEwOThmYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.3paYzYVdTalVxIxajErFCrZ-MQ_4i-m3P_bxEa7jTPU";
        String requestToken = authenticator.getRequestToken(accessToken);
        logger.info("Request Token: "+requestToken);

    }
}
