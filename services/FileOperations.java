package notebook_atestat.services;

import java.util.List;
import notebook_atestat.models.Note;

public interface FileOperations {
    boolean saveNotes(List<Note> notes, String filename);

    List<Note> loadNotes(String filename);
}
