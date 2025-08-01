package com.mynotes.notesappwithrestrepository.repository;


import com.mynotes.notesappwithrestrepository.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotesRepository extends JpaRepository<Note,Integer> {

    @Query("from Note where title=:title")
    Note findByTitle(String title);

    List<Note> findByTitleContainsIgnoreCase(String title);

}
