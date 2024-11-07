package notebook_atestat.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import notebook_atestat.models.Note;
import notebook_atestat.services.views.InputView;
import notebook_atestat.services.views.MessageView;

public class NotebookPresenter {
    private InputView inputView;
    private MessageView messageView;
    private NotebookController notebookController;

    public NotebookPresenter(InputView inputView, MessageView messageView, NotebookController notebookController) {
        this.inputView = inputView;
        this.messageView = messageView;
        this.notebookController = notebookController;
    }

    public void createNewNote() {
        String title = inputView.promptForTitle();
        LocalDate date = inputView.promptForDate();
        LocalTime time = inputView.promptForTime();
        String description = inputView.promptForDescription();

        boolean success = notebookController.addNote(title, date, time, description);

        if (success) {
            messageView.showSuccessMessage("Note added successfully!");
        } else {
            messageView.showErrorMessage("Failed to add note.");
        }
    }

    public void getNotesByDate(LocalDate date) {
        List<Note> success = notebookController.getNotesByDate(date);
        if (!success.isEmpty()) {
            messageView.showSuccessMessage("Here are notes for that date \n");
            for (Note note : success) {
                System.out.println(note);
            }
        } else {
            messageView.showErrorMessage("There are no such notes in this date");
        }
    }

    public void getNotesByWeek(LocalDate startOfWeek) {
        List<Note> success = notebookController.getNotesByWeek(startOfWeek);
        if (!success.isEmpty()) {
            messageView.showSuccessMessage("Here are notes for that date \n");
            for (Note note : success) {
                System.out.println(note);
            }
        } else {
            messageView.showErrorMessage("There are no such notes in this week");
        }
    }

    public void getSortedByTitle() {
        List<Note> sorted = notebookController.sortByTitle();
        if (!sorted.isEmpty()) {
            messageView.showSuccessMessage("Here are sorted notes by title \n");
            for (Note note : sorted) {
                System.out.println(note);
            }
        } else {
            messageView.showErrorMessage("Sorry something went wrong");
        }
    }

    public void getSortedByDate() {
        List<Note> sorted = notebookController.sortByDate();
        if (!sorted.isEmpty()) {
            messageView.showSuccessMessage("Here are sorted notes by date \n");
            for (Note note : sorted) {
                System.out.println(note);
            }
        } else {
            messageView.showErrorMessage("Sorry something went wrong");
        }
    }
}
