package io.github.rkeeves.pfpls.widget.datepicker;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.focused;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

import com.codeborne.selenide.SelenideElement;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.Keys;

@RequiredArgsConstructor
public class DatePicker {

  private final SelenideElement spanDatepicker;

  public void setValue(final String newValue) {
    final String panelId = spanDatepicker.attr("id") + "_panel";
    spanDatepicker.$("input").shouldBe(enabled).click();
    $(id(panelId)).shouldBe(visible);
    spanDatepicker.$("input").shouldBe(focused).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    spanDatepicker.$("input").setValue(newValue);
    spanDatepicker.$("input").shouldHave(value(newValue));
    $("html").click();
    $(id(panelId)).shouldNotBe(visible);
  }

  public void shouldHaveValue(final String expectedValue) {
    spanDatepicker.$("input").shouldHave(value(expectedValue));
  }
}
