package com.mynotes.api;

import com.mynotes.model.Note;
import com.mynotes.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {

    @Autowired
    NotesRepository repo;

    @PostMapping
    public Note createNote(@RequestBody Note note){
        note.setCreationTime(LocalDateTime.now());
        return repo.save(note);
    }

    @GetMapping
    public List<Note> getAllNotes(){
        return repo.findAll();
    }

    @GetMapping("/{title}")
    public Note getNoteByTitle(@PathVariable String title) {
        return repo.findByTitleIgnoreCase(title);
    }


}
