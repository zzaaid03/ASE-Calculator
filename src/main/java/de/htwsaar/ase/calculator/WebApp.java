package de.htwsaar.ase.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Spring Boot entry point for the web calculator. */
@SpringBootApplication
public class WebApp {

  public static void main(String[] arguments) {
    SpringApplication.run(WebApp.class, arguments);
  }
}
