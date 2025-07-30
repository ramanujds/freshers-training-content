package com.mynotes.app.service;

import com.mynotes.app.model.Note;
import com.mynotes.app.repository.NotesRepository;
import com.mynotes.app.repository.NotesRepositoryImpl;

import java.util.List;

public class NotesServiceImpl implements NotesService {

    private NotesRepository notesRepository = new NotesRepositoryImpl();

    @Override
    public Note getNoteById(int id) {
        return notesRepository.getNoteById(id);
    }

    @Override
    public List<Note> getAllNotes() {
        return notesRepository.getAllNotes();
    }

    @Override
    public Note getNoteByTitle(String title) {
        return notesRepository.getNoteByTitle(title);
    }

    @Override
    public Note createNote(Note note) {
        notesRepository.addNote(note);
        return note;
    }

    @Override
    public void deleteNote(int id) {
        notesRepository.deleteNote(id);
    }
}
