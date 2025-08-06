package com.mynotes.api;

import com.mynotes.model.Note;
import com.mynotes.repository.NotesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@WebMvcTest(NotesController.class)
class NotesControllerTest {

    @MockitoBean
    private NotesRepository notesRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getNoteByIdReturnsNoteWhenIdExists() throws Exception {
        Long noteId = 1L;
        Note note = new Note();
        note.setId(noteId);
        note.setTitle("Sample Note");
        note.setContent("Sample Content");

        when(notesRepository.findById(noteId)).thenReturn(Optional.of(note));

        mockMvc.perform(
            get("/api/v1/notes/{id}", noteId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(noteId))
            .andExpect(jsonPath("$.title").value("Sample Note"))
            .andExpect(jsonPath("$.content").value("Sample Content")

        ).andReturn();

    }


    void getNoteByIdReturnsNullWhenIdDoesNotExist() {
        Long noteId = 1L;

        when(notesRepository.findById(noteId)).thenReturn(Optional.empty());

        //Note result = notesController.getNoteById(noteId);

        //assertNull(result);
    }
}
