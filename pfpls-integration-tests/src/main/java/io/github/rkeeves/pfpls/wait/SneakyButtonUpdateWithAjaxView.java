package io.github.rkeeves.pfpls.wait;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ViewScoped
public class SneakyButtonUpdateWithAjaxView {

  private boolean shouldDisplayFirst;

  private String message;

  @PostConstruct
  public void init() {
    shouldDisplayFirst = true;
    message = "failed";
  }

  public void onFirstButtonClick() throws InterruptedException {
    Thread.sleep(800L);
    shouldDisplayFirst = false;
  }

  public void onSecondButtonClick() {
    message = "passed";
  }
}
