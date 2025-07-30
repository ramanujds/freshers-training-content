package com.mynotes.app.service;

import com.mynotes.app.model.Note;

import java.util.List;

public interface NotesService {

    Note getNoteById(int id);
    List<Note> getAllNotes();
    Note getNoteByTitle(String title);
    Note createNote(Note note);
    Note deleteNote(int id);

}
