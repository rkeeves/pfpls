package io.github.rkeeves.pfpls.widget.autocomplete;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static org.openqa.selenium.By.id;

import com.codeborne.selenide.SelenideElement;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AutoComplete {

  private final SelenideElement spanUiAutoComplete;

  public void setValue(final String keyword, final String selectedLabel) {
    spanUiAutoComplete.$("input").setValue(keyword);
    final String panelId = spanUiAutoComplete.attr("id") + "_panel";
    final SelenideElement li = $(id(panelId))
            .shouldBe(visible)
            .$("ul > li[data-item-label='" + selectedLabel + "']")
            .scrollIntoView(false);
    actions().moveToElement(li)
            .clickAndHold(li)
            .release(li)
            .build()
            .perform();
    $(id(panelId))
            .shouldNotBe(visible);
    spanUiAutoComplete.$("input").shouldHave(value(selectedLabel));
  }
}
