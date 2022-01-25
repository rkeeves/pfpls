package io.github.rkeeves.pfpls.widget.autocomplete;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ViewScoped
public class TwoAutoCompletesWithAjaxView {

  private String first;

  private List<String> firstSuggestions;

  private String second;

  private List<String> secondSuggestions;

  @PostConstruct
  public void init() {
    firstSuggestions = Stream.of("a", "b", "c")
            .flatMap(alpha -> IntStream.range(0, 10)
                    .mapToObj(Integer::toString)
                    .map(digit -> alpha + digit))
            .collect(Collectors.toList());
  }

  public List<String> provideSuggestionsForFirst(String prefix) throws InterruptedException {
    Thread.sleep(1000L);
    return firstSuggestions.stream()
            .filter(word -> word.startsWith(prefix))
            .collect(Collectors.toList());
  }

  public List<String> provideSuggestionsForSecond(String prefix) throws InterruptedException {
    Thread.sleep(1000L);
    return secondSuggestions.stream()
            .filter(word -> word.startsWith(prefix))
            .collect(Collectors.toList());
  }

  public void onFirstHasBeenSelected(AjaxBehaviorEvent event) throws InterruptedException {
    Thread.sleep(1000L);
    secondSuggestions = createSecondSuggestions(first);
  }

  private List<String> createSecondSuggestions(final String first) {
    return IntStream.range(0, 10)
            .mapToObj(Integer::toString)
            .map(digit -> first + digit)
            .collect(Collectors.toList());
  }

}
