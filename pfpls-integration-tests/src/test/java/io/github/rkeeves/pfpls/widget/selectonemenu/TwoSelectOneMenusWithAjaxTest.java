package io.github.rkeeves.pfpls.widget.selectonemenu;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.openqa.selenium.By.id;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.UIAssertionError;
import io.github.rkeeves.pfpls.BaseTest;
import io.github.rkeeves.pfpls.PfPls;
import io.github.rkeeves.pfpls.wait.AwaitPf;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoSelectOneMenusWithAjaxTest extends BaseTest {

  private static final AwaitPf awaitPf = PfPls.createWaitForPf(Duration.of(5, ChronoUnit.SECONDS));

  private static class TwoSelectOneMenusWithAjaxPage {

    private final SelectOneMenu first = new SelectOneMenu($(id("pf_form:first")));

    private final SelectOneMenu second = new SelectOneMenu($(id("pf_form:second")));

    public static TwoSelectOneMenusWithAjaxPage openPage() {
      open("/widget/selectonemenu/two_selectonemenus_with_ajax.xhtml");
      return new TwoSelectOneMenusWithAjaxPage();
    }
  }

  @BeforeEach
  void resetDriver() {
    Selenide.closeWebDriver();
    WebDriverRunner.removeListener(awaitPf);
  }

  @Test
  void performActions_withoutAwaitPf_shouldThrow() {
    assertThrows(UIAssertionError.class, this::performActions);
  }

  @Test
  void performActions_withAwaitPf_shouldNotThrow() {
    WebDriverRunner.addListener(awaitPf);
    performActions();
  }

  private void performActions() {
    TwoSelectOneMenusWithAjaxPage page = TwoSelectOneMenusWithAjaxPage.openPage();
    page.first.setSelected("0");
    page.second.setSelected("099");
    page.first.setSelected("5");
    page.second.setSelected("587");
    page.first.setSelected("9");
    page.second.setSelected("999");
  }
}
