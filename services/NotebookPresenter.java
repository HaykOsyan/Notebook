package notebook_atestat.services;

import java.time.LocalDate;
import java.time.LocalTime;

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
}
