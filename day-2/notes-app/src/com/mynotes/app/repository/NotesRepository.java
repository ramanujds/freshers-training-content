package com.mynotes.app.repository;

import com.mynotes.app.model.Note;

import java.util.List;


public interface NotesRepository {

     void addNote(Note note);


     void deleteNote(int id);


     void updateNote(Note note);

     List<Note> getAllNotes();

     Note getNoteById(int id);

     Note getNoteByTitle(String name);

}
