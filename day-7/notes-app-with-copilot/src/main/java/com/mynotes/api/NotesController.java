package com.mynotes.api;

import com.mynotes.model.Note;
import com.mynotes.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {

    @Autowired
    private NotesRepository notesRepository;

    // GET: /api/v1/notes
    // This endpoint will return all notes
    @GetMapping
    public List<Note> getAllNotes() {
        return notesRepository.findAll();
    }

    // POST: /api/v1/notes
    // This endpoint will create a new note
 @PostMapping
 public Note createNote(@RequestBody Note note) {
     return notesRepository.save(note);
 }

    // GET: /api/v1/notes/{id}
    // This endpoint will return a note by its ID
    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return notesRepository.findById(id).orElse(null);
    }



    // DELETE: /api/v1/notes/{id}
    // This endpoint will delete a note by its ID
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        notesRepository.deleteById(id);
    }

    // GET: /api/v1/notes/search
    // This endpoint will search notes by title or content
    @GetMapping("/search")
    public List<Note> searchNotes(@RequestParam(required = false) String title,
                                   @RequestParam(required = false) String content) {
        if (title != null && !title.isEmpty()) {
            return notesRepository.findByTitleContainingIgnoreCase(title);
        } else if (content != null && !content.isEmpty()) {
            return notesRepository.findByContentContainingIgnoreCase(content);
        } else {
            return notesRepository.findAll();
        }
    }

    // GET: /api/v1/notes/count
    // This endpoint will return the count of all notes
    @GetMapping("/count")
    public long getNotesCount() {
        return notesRepository.count();
    }


    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note) {
        if (!notesRepository.existsById(id)) {
            return null; // or throw an exception
        }
        note.setId(id);
        return notesRepository.save(note);
    }




}
