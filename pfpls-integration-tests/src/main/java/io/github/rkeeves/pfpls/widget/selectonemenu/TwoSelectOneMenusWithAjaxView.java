package io.github.rkeeves.pfpls.widget.selectonemenu;

import static java.util.function.Function.identity;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ViewScoped
public class TwoSelectOneMenusWithAjaxView {

  private Map<String, Map<String, String>> secondsByFirsts = new HashMap<>();
  private String first;
  private String second;
  private Map<String, String> firsts;
  private Map<String, String> seconds;

  @PostConstruct
  public void init() {
    firsts = IntStream.range(0, 10)
            .mapToObj(Integer::toString)
            .collect(Collectors.toMap(identity(), identity()));

    secondsByFirsts = firsts.keySet().stream()
            .collect(Collectors.toMap(identity(), firstDigit -> IntStream.range(0, 100)
                    .mapToObj(Integer::toString)
                    .map(secondDigit -> firstDigit + secondDigit)
                    .collect(Collectors.toMap(identity(), identity()))));
  }

  public void onFirstChange() throws InterruptedException {
    Thread.sleep(1000L);
    if (first != null && !first.equals("")) {
      seconds = secondsByFirsts.get(first);
    } else {
      seconds = new HashMap<>();
    }
  }
}
