package notebook_atestat.services.views;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import notebook_atestat.models.Note;
import notebook_atestat.services.FileOperations;

public class FileOperationsImplement implements FileOperations {
    @Override
    public boolean saveNotes(List<Note> notes, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(notes);
            return true;
        } catch (IOException e) {
            System.err.println("Error saving notes: " + e.getMessage());
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Note> loadNotes(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Note>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading notes: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
