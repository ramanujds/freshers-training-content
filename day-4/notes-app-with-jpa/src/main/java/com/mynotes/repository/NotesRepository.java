package com.mynotes.repository;

import com.mynotes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Note,Integer> {
}
