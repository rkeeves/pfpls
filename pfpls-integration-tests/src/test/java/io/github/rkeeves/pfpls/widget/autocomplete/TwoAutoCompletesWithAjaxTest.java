package io.github.rkeeves.pfpls.widget.autocomplete;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.openqa.selenium.By.id;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.UIAssertionError;
import io.github.rkeeves.pfpls.BaseTest;
import io.github.rkeeves.pfpls.PfPls;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.events.WebDriverListener;

public class TwoAutoCompletesWithAjaxTest extends BaseTest {

  private static final WebDriverListener waitForPf = PfPls.createWaitForPf(Duration.of(5, ChronoUnit.SECONDS));

  private static class TwoAutoCompletesWithAjaxPage {

    private final AutoComplete first = new AutoComplete($(id("pf_form:first")));

    private final AutoComplete second = new AutoComplete($(id("pf_form:second")));

    public static TwoAutoCompletesWithAjaxPage openPage() {
      open("/widget/autocomplete/two_autocompletes_with_ajax.xhtml");
      return new TwoAutoCompletesWithAjaxPage();
    }
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
    TwoAutoCompletesWithAjaxPage page = TwoAutoCompletesWithAjaxPage.openPage();
    page.first.setValue("a", "a0");
    page.second.setValue("a0", "a04");
    page.first.setValue("b", "b5");
    page.second.setValue("b5", "b59");
    page.first.setValue("c", "c9");
    page.second.setValue("c9", "c92");
  }
}
