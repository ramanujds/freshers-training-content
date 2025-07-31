package com.mynotes.api;

import com.mynotes.model.Note;
import com.mynotes.repository.NotesRepository;
import com.mynotes.repository.NotesRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {

    @Autowired
    private NotesRepository repo;


    @PostMapping
    public Note createNote(@RequestBody Note note){
        return repo.saveNote(note);
    }

    @GetMapping
    public List<Note> getAllNotes(){
        return repo.getAllNotes();
    }

    @GetMapping("/{id}")
    public Note findNote(@PathVariable("id") int id){
        return repo.getNoteById(id);
    }




}
