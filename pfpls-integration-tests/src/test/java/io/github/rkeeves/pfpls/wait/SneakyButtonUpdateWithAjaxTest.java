package io.github.rkeeves.pfpls.wait;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.openqa.selenium.By.id;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.UIAssertionError;
import io.github.rkeeves.pfpls.BaseTest;
import io.github.rkeeves.pfpls.PfPls;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.events.WebDriverListener;

class SneakyButtonUpdateWithAjaxTest extends BaseTest {

  private static final WebDriverListener waitForPf = PfPls.createWaitForPf(Duration.of(5, ChronoUnit.SECONDS));

  @BeforeEach
  void resetDriver() {
    Selenide.closeWebDriver();
    WebDriverRunner.removeListener(waitForPf);
  }

  @Test
  void performActions_withoutAwaitPf_shouldThrow() {
    assertThrows(UIAssertionError.class, this::performActions);
  }

  @Test
  void performActions_withAwaitPf_shouldNotThrow() {
    WebDriverRunner.addListener(waitForPf);
    performActions();
  }

  private void performActions() {
    open("/wait/sneaky_button_update_with_ajax.xhtml");
    $(id("pf_form:message")).shouldHave(text("failed"));
    $("button").click();
    $("button").click();
    $(id("pf_form:message")).shouldHave(text("passed"));
  }
}
