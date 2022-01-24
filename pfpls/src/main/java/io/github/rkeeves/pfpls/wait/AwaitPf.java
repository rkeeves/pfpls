package io.github.rkeeves.pfpls.wait;

import java.lang.reflect.Method;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor
public class AwaitPf implements WebDriverListener {

  private final Duration waitTimeout;

  private final ExpectedCondition<Boolean> condition;

  @Override
  public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args) {
    awaitTrue(driver);
  }

  @Override
  public void beforeFindElement(WebDriver driver, By locator) {
    awaitTrue(driver);
  }

  @Override
  public void beforeFindElements(WebDriver driver, By locator) {
    awaitTrue(driver);
  }

  private void awaitTrue(WebDriver driver) {
    new WebDriverWait(driver, waitTimeout).until(condition);
  }
}
