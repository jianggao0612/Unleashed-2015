package au.id.tmoschou.unleashed.game.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry-point and configuration for the application.
 */
@SpringBootApplication
public class Application  {


    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    /**
     * Runs the application
     *
     * @param args A set of command-line arguments.
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
        LOGGER.debug("Started Identity Application");
    }

}
