package io.github.rkeeves.pfpls.view;

import javax.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ViewScoped
public class IndexView {

  private String hello = "hello";

  private String world = "world";
}
