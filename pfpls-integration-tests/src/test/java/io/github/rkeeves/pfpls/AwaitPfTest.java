package io.github.rkeeves.pfpls;

import com.codeborne.selenide.WebDriverRunner;
import io.github.rkeeves.pfpls.wait.AwaitPf;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class AwaitPfTest extends BaseTest {

  private static final AwaitPf waitForPf = PfPls.createWaitForPf(Duration.of(5, ChronoUnit.SECONDS));

  @BeforeAll
  static void beforeAll() {
    WebDriverRunner.addListener(waitForPf);
  }

  @AfterAll
  static void afterAll() {
    WebDriverRunner.removeListener(waitForPf);
  }
}
