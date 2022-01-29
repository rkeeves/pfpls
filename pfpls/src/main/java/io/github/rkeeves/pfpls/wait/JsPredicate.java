package io.github.rkeeves.pfpls.wait;

import com.codeborne.selenide.impl.FileContent;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

@RequiredArgsConstructor
public class JsPredicate implements ExpectedCondition<Boolean> {

  private final FileContent jsExpressionEvaluatingToBoolean;

  @Override
  public Boolean apply(WebDriver webDriver) {
    if (webDriver == null) {
      return false;
    }
    JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) webDriver;
    final Object result = javaScriptExecutor.executeScript("return " + jsExpressionEvaluatingToBoolean.content() + ";");
    return Boolean.valueOf(result.toString());
  }
}
