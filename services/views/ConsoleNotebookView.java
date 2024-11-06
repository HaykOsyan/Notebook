package notebook_atestat.services.views;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import notebook_atestat.models.Note;

public class ConsoleNotebookView implements InputView, MessageView, NoteView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayNote(Note note) {
        System.out.println(note);
    }

    @Override
    public void displayNotes(List<Note> notes) {
        notes.forEach(System.out::println);
    }

    @Override
    public void showSuccessMessage(String message) {
        System.out.println("Success" + message);
    }

    @Override
    public void showErrorMessage(String message) {
        System.out.println("Error" + message);
    }

    @Override
    public void showInfoMessage(String message) {
        System.out.println("information" + message);
    }

    @Override
    public String promptForTitle() {
        System.out.print("Enter title: ");
        return scanner.nextLine();
    }

    @Override
    public LocalDate promptForDate() {
        System.out.print("Enter date: format YYYY-MM-DD   ");
        return LocalDate.parse(scanner.nextLine());
    }

    @Override
    public LocalTime promptForTime() {
        System.out.print("Enter time: format HH:MM   ");
        return LocalTime.parse(scanner.nextLine());
    }

    @Override
    public String promptForDescription() {
        System.out.print("Enter Description: ");
        return scanner.nextLine();
    }
}
