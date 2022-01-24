package io.github.rkeeves.pfpls;

import com.codeborne.selenide.Configuration;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseTest {

  @Setter
  @LocalServerPort
  private Integer port;

  @BeforeEach
  final void beforeEach() {
    Configuration.baseUrl = "http://localhost:" + port;
  }
}

