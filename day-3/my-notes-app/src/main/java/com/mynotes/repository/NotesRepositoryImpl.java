package com.mynotes.repository;

import com.mynotes.model.Note;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotesRepositoryImpl implements NotesRepository{

    List<Note> notes = new ArrayList<>();

    public Note saveNote(Note note) {
        notes.add(note);
        return note;
    }

    public Note getNoteById(int id) {
        return notes.stream().filter(n->n.getId()==id).findFirst().orElse(null);
    }

    public List<Note> getAllNotes() {
        return notes;
    }

    public void deleteNode(int id) {
        notes.removeIf(n->n.getId()==id);
    }

}
