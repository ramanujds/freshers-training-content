package com.mynotes.repository;

import com.mynotes.model.Note;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotesRepositoryImpl implements NotesRepository{

    List<Note> notes = new ArrayList<>();

    @PostConstruct
    void init(){
        Note note1 = new Note(1,"ReactJS", "Learn ReactJS for building user interfaces");
        Note note2 = new Note(2,"Spring Boot", "Learn Spring Boot for building backend applications");
        Note note3 = new Note(3,"Java", "Learn Java for building robust applications");
        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
    }

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
