package com.mynotes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Data
@Entity
public class Note {

    @Id
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;


}
