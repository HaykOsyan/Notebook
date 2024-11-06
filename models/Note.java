package notebook_atestat.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Note {
    private static int lastId = 0;
    private LocalDate date;
    private int id;
    private LocalTime time;
    private String title;
    private String description;

    public Note(LocalDate date, LocalTime time, String title, String description) {
        this.id = ++lastId;
        this.date = date;
        this.time = time;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return lastId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Date: %s, Time: %s, Title: %s, Description: %s", id, date, time, title,
                description+"\n");
    }
}
