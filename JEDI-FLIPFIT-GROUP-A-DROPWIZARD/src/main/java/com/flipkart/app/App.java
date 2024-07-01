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


public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");

        e.jersey().register(new GymFlipFitAdminController());
        e.jersey().register(new GymFlipFitOwnerController());
        e.jersey().register(new GymFlipFitCustomerController());

    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}