package com.mynotes.api;

import com.mynotes.model.Note;
import com.mynotes.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {

    @Autowired
    private NotesRepository repo;

    @PostMapping
    public Note createNote(@RequestBody Note note){
        if(repo.existsById(note.getId())){
            throw new RuntimeException("Note with id "+note.getId()+" already exist");
        }
       return repo.save(note);
    }

    @GetMapping
    public List<Note> getAllNotes(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Note findById(@PathVariable int id){
        return repo.findById(id).orElse(null);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        if(!repo.existsById(id)){
            throw new RuntimeException("Note with id "+id+" not present");
        }
        repo.deleteById(id);
    }

    @PutMapping
    public Note updateNote(@RequestBody Note note){
        if(!repo.existsById(note.getId())){
            throw new RuntimeException("Note with id "+note.getId()+" not present");
        }
        return repo.save(note);
    }

    @GetMapping("/search")
    public List<Note> findAllByTitle(@RequestParam("title") String title){
        return repo.findByTitleContainsIgnoreCase(title);
    }


}
