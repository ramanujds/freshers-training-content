package com.mynotes.notesappwithrestrepository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
@Data
public class Note {

    @Id
    private int id;
    @Column(nullable = false, length = 100)
    private String title;
    private String content;
    @Column(name = "creation_time")
    private LocalDateTime creationTime;

}
