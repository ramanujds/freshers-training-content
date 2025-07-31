package com.mynotes.repository;

import com.mynotes.exception.DuplicateRecordException;
import com.mynotes.exception.RecordNotFoundException;
import com.mynotes.model.Note;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        Note exists = notes.stream().filter(n->n.getId()==note.getId()).findFirst().orElse(null);
        if(exists != null){
            throw new DuplicateRecordException("Node with id "+note.getId()+" Already Present");
        }
        notes.add(note);
        return note;
    }

    public Note getNoteById(int id) {
        return notes.stream().filter(n->n.getId()==id)
                .findFirst()
                .orElseThrow(()->new RecordNotFoundException("Note with id "+id+" Not Found"));
    }

    public List<Note> getAllNotes() {
        return notes;
    }

    public void deleteNode(int id) {
        notes.removeIf(n->n.getId()==id);
    }

    public List<Note> findNotesByTitle(String title) {

        return notes.stream().filter(n->n.getTitle().toLowerCase().contains(title.toLowerCase()))
                .toList();

    }
}
