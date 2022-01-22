package io.github.rkeeves.pfpls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PfPlsItApp extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(PfPlsItApp.class, args);
  }
}
