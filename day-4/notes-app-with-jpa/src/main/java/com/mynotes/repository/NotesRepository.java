package com.mynotes.repository;

import com.mynotes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotesRepository extends JpaRepository<Note,Integer> {

    @Query("from Note where title=:title")
    Note findByTitle(String title);

    List<Note> findByTitleContainsIgnoreCase(String title);

}
