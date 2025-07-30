package com.mynotes.app.repository;

import com.mynotes.app.model.Note;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NotesRepositoryImpl implements NotesRepository {

    List<Note> notes  = new ArrayList<>();

    public void addNote(Note note) {
        notes.add(note);
    }

    public void deleteNote(int id) {
        Note note = getNoteById(id);
        notes.remove(note);
    }

    public void updateNote(Note note) {

    }

    public List<Note> getAllNotes() {
        return notes;
    }

    public Note getNoteById(int id) {
       return notes.stream().filter(note -> note.getId() == id).findFirst().get();
    }

    public Note getNoteByTitle(String title) {
        for(Note note : notes) {
            if (note.getTitle().equalsIgnoreCase(title)) {
                return note;
            }
        }
        return null;
    }
}
