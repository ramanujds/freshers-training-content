package com.mynotes.model;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
