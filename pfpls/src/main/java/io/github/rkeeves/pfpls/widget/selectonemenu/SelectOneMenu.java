package io.github.rkeeves.pfpls.widget.selectonemenu;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static org.openqa.selenium.By.id;

import com.codeborne.selenide.SelenideElement;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SelectOneMenu {

  private final SelenideElement divUiSelectOneMenu;

  public void setSelected(final String dataLabel) {
    final String itemsElementId = divUiSelectOneMenu
            .shouldHave(cssClass("ui-selectonemenu"))
            .attr("aria-owns");
    divUiSelectOneMenu.$("label").click();
    SelenideElement li = $(id(itemsElementId))
            .shouldBe(visible)
            .$("ul > li[data-label='" + dataLabel + "']")
            .scrollIntoView(false);
    actions().moveToElement(li)
            .clickAndHold(li)
            .release(li)
            .build()
            .perform();
    $(id(itemsElementId))
            .shouldNotBe(visible);
    divUiSelectOneMenu.$("label").shouldHave(exactText(dataLabel));
  }

  public String getSelected() {
    return divUiSelectOneMenu.$("label").text();
  }

  public SelectOneMenu shouldHaveSelected(final String dataLabel) {
    divUiSelectOneMenu.$("label").shouldHave(exactText(dataLabel));
    return this;
  }
}
