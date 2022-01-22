package io.github.rkeeves.pfpls.view;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;

@Setter
@Getter
@Component
@ViewScoped
public class IndexView {

    private String hello = "hello";

    private String world = "world";
}
