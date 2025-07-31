package com.mynotes.api;

import com.mynotes.model.Note;
import com.mynotes.repository.NotesRepository;
import com.mynotes.repository.NotesRepositoryImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {

    private NotesRepository repo;

    public NotesController(NotesRepository repo) {
        this.repo = repo;
    }


    @PostMapping
    public Note createNote(@RequestBody Note note){
        return repo.saveNote(note);
    }

    @GetMapping
    public List<Note> getAllNotes(){
        return repo.getAllNotes();
    }




}
