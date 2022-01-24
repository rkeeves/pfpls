package io.github.rkeeves.pfpls;

import com.codeborne.selenide.WebDriverRunner;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.support.events.WebDriverListener;

public class AwaitPfTest extends BaseTest {

  private static final WebDriverListener waitForPf = PfPls.createWaitForPf(Duration.of(5, ChronoUnit.SECONDS));

  @BeforeAll
  static void beforeAll() {
    WebDriverRunner.addListener(waitForPf);
  }

  @AfterAll
  static void afterAll() {
    WebDriverRunner.removeListener(waitForPf);
  }
}
