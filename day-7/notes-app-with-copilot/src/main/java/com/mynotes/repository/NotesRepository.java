package com.mynotes.repository;

import com.mynotes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesRepository extends JpaRepository<Note, Long> {

    // get all notes by title
    List<Note> findByTitleContainingIgnoreCase(String title);
    // get all notes by content
    List<Note> findByContentContainingIgnoreCase(String content);

}
