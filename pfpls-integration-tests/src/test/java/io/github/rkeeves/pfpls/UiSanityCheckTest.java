package io.github.rkeeves.pfpls;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.Test;

public class UiSanityCheckTest extends AbstractUiTest {

  @Test
  void test() {
    open("/index.xhtml");
    $("h2").shouldHave(text("Index"));
  }
}