package com.flipkart.app;

import com.flipkart.restcontroller.GymFlipFitAdminController;
import com.flipkart.restcontroller.GymFlipFitCustomerController;
import com.flipkart.restcontroller.GymFlipFitOwnerController;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main application class for initializing and running the FlipFit application.
 */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    /**
     * Initializes the application bootstrap.
     *
     * @param b the bootstrap object
     */
    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    /**
     * Runs the application, registering REST resources.
     *
     * @param c the application configuration
     * @param e the application environment
     * @throws Exception if there is an error running the application
     */
    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");

        e.jersey().register(new GymFlipFitAdminController());
        e.jersey().register(new GymFlipFitOwnerController());
        e.jersey().register(new GymFlipFitCustomerController());

    }

    /**
     * Main method to start the FlipFit application.
     *
     * @param args command line arguments
     * @throws Exception if there is an error starting the application
     */
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}