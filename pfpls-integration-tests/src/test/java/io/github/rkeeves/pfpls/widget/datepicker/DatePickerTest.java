package io.github.rkeeves.pfpls.widget.datepicker;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.id;

import io.github.rkeeves.pfpls.AwaitPfTest;
import org.junit.jupiter.api.Test;

public class DatePickerTest extends AwaitPfTest {

  static class DatePickerPage {

    private final DatePicker date = new DatePicker($(id("pf_form:date")));

    private final DatePicker dateTime = new DatePicker($(id("pf_form:dateTime")));

    static DatePickerPage openPage() {
      open("/widget/datepicker/datepicker.xhtml");
      return new DatePickerPage();
    }
  }

  @Test
  void shouldBeAbleToWaitOutAjax() {
    DatePickerPage page = DatePickerPage.openPage();
    page.date.setValue("1999.10.05.");
    page.dateTime.shouldHaveValue("");
    page.dateTime.setValue("1999.10.05. 13:01");
    page.date.shouldHaveValue("");
    page.date.setValue("1999.11.06.");
    page.dateTime.shouldHaveValue("");
    page.dateTime.setValue("1999.12.15. 11:01");
    page.date.shouldHaveValue("");
  }
}
