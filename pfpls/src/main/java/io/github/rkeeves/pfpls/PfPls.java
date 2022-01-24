package io.github.rkeeves.pfpls;

import com.codeborne.selenide.impl.FileContent;
import io.github.rkeeves.pfpls.wait.AwaitPf;
import io.github.rkeeves.pfpls.wait.JsPredicate;
import java.time.Duration;

public class PfPls {

  public static AwaitPf createWaitForPf(final Duration timeout) {
    return new AwaitPf(timeout, new JsPredicate(new FileContent("js/is_pf_ready.js")));
  }
}
