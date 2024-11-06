package notebook_atestat.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Notebook {
    private Map<Integer, Note> notes = new HashMap<>();

    public boolean addNote(String title, LocalDate date, LocalTime time, String description) {
        Note newNote = new Note(date, time, title, description);
        notes.put(newNote.getId(), newNote);
        return true;
    }

    public Note getNoteById(int id) {
        return notes.get(id);
    }

    public Map<Integer, Note> getAllNotes() {
        return notes;
    }

    public boolean updateNote(int id, String title, LocalDate date, LocalTime time, String description) {
        Note note = notes.get(id);
        if (note != null) {
            note.setTitle(title);
            note.setDate(date);
            note.setTime(time);
            note.setDescription(description);
            return true;
        }
        return false;
    }

    public boolean deleteNoteById(int id) {
        return notes.remove(id) != null;
    }
}
