package notebook_atestat.main;

import java.time.LocalDate;
import java.util.Scanner;

import notebook_atestat.models.Notebook;
import notebook_atestat.services.FileOperations;
import notebook_atestat.services.NotebookController;
import notebook_atestat.services.NotebookPresenter;
import notebook_atestat.services.views.ConsoleNotebookView;
import notebook_atestat.services.views.FileOperationsImplement;

public class Main {

    public static void main(String[] args) {
        ConsoleNotebookView consoleView = new ConsoleNotebookView();

        FileOperations fileOperations = new FileOperationsImplement();
        Notebook notebook = new Notebook();
        NotebookController notebookController = new NotebookController(notebook, fileOperations);
        NotebookPresenter notebookPresenter = new NotebookPresenter(consoleView, consoleView, notebookController);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create a new note");
            System.out.println("2. Display all notes");
            System.out.println("22. Display notes by Date");
            System.out.println("3. Save notes to file");
            System.out.println("4. Load notes from file");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    notebookPresenter.createNewNote();
                    break;
                case 2:
                    System.out.println("\nAll notes:");
                    notebook.getAllNotes().values().forEach(System.out::println);
                    break;
                case 22:
                    System.out.println("Enter year (e.g., 2024): ");
                    int year = scanner.nextInt();

                    System.out.println("Enter month (1-12): ");
                    int month = scanner.nextInt();

                    System.out.println("Enter day (1-31): ");
                    int day = scanner.nextInt();
                    LocalDate date = LocalDate.of(year, month, day);
                    notebook.getNotesByDate(date).forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter filename to save notes: ");
                    String saveFilename = scanner.nextLine();
                    if (notebookController.saveNotesToFile(saveFilename)) {
                        consoleView.showSuccessMessage("Notes saved successfully!");
                    } else {
                        consoleView.showErrorMessage("Failed to save notes.");
                    }
                    break;
                case 4:
                    System.out.print("Enter filename to load notes: ");
                    String loadFilename = scanner.nextLine();
                    notebookController.loadNotesFromFile(loadFilename);
                    consoleView.showSuccessMessage("Notes loaded successfully!");
                    break;
                case 5:
                    running = false;
                    consoleView.showInfoMessage("Exiting the application.");
                    break;
                default:
                    consoleView.showErrorMessage("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
