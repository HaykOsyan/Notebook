package notebook_atestat.services.views;

import java.util.List;

import notebook_atestat.models.Note;

public interface NoteView {
    void displayNote(Note note);

    void displayNotes(List<Note> notes);
}
