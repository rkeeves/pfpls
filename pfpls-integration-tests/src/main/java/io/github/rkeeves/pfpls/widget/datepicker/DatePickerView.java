package io.github.rkeeves.pfpls.widget.datepicker;

import java.util.Date;
import javax.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ViewScoped
public class DatePickerView {

  private Date date;

  private Date dateTime;

  public void onDateChange() throws InterruptedException {
    Thread.sleep(1000L);
    dateTime = null;
  }

  public void onDateTimeChange() throws InterruptedException {
    Thread.sleep(1000L);
    date = null;
  }
}
