package notebook_atestat.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import notebook_atestat.models.Note;
import notebook_atestat.models.Notebook;

public class NotebookController {
    private Notebook notebook;
    private FileOperations fileOperations;

    public NotebookController(Notebook notebook, FileOperations fileOperations) {
        this.notebook = notebook;
        this.fileOperations = fileOperations;
    }

    public boolean addNote(String title, LocalDate date, LocalTime time, String description) {
        return notebook.addNote(title, date, time, description);
    }

    public List<Note> getNotesByDate(LocalDate date) {
        return notebook.getAllNotes().values().stream()
                .filter(note -> note.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public boolean saveNotesToFile(String filename) {
        List<Note> noteList = new ArrayList<>(notebook.getAllNotes().values());
        return fileOperations.saveNotes(noteList, filename);
    }

    public void loadNotesFromFile(String filename) {
        List<Note> loadedNotes = fileOperations.loadNotes(filename);
        for (Note note : loadedNotes) {
            notebook.addNote(
                    note.getTitle(),
                    note.getDate(),
                    note.getTime(),
                    note.getDescription());
        }
    }

}
