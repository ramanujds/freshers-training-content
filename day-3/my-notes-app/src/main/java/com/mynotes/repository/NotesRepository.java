package com.mynotes.repository;

import com.mynotes.model.Note;

import java.util.List;

public interface NotesRepository {

    Note saveNote(Note note);

    Note getNoteById(int id);

    List<Note> getAllNotes();

    void deleteNode(int id);

    List<Note> findNotesByTitle(String title);

}
