package com.lalivraison.api;

import com.lalivraison.api.com.lalivraison.api.controllers.HomePageController;
import java.io.IOException;
import java.util.Arrays;
import java.util.ListIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LalivraisonApiApplication implements CommandLineRunner {


  @Autowired
  private HomePageController homePageController;

  public static void main(String[] args) {
    SpringApplication.run(LalivraisonApiApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
  }
}
