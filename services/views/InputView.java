package notebook_atestat.services.views;

import java.time.LocalDate;
import java.time.LocalTime;

public interface InputView {
    String promptForTitle();

    LocalDate promptForDate();

    LocalTime promptForTime();

    String promptForDescription();
}
