package com.mynotes.app.api;

import com.mynotes.app.model.Note;
import com.mynotes.app.service.NotesService;
import com.mynotes.app.service.NotesServiceImpl;

import java.util.List;

public class NotesApp {

    public static void main(String[] args) {

        // Create two notes

        Note note1 = new Note(1,"Java","Java is a Object Oriented Language");
        Note note2 = new Note(2,"Docker","Docker is a Containerization Platform");

        NotesService service = new NotesServiceImpl();

        // Add them

        service.createNote(note1);
        service.createNote(note2);

        // Print all

       List<Note> allNotes = service.getAllNotes();
       for( Note note : allNotes ){
           System.out.println(note);
       }

        // Search by Id

        // Search by title

        // Delete



    }

}
