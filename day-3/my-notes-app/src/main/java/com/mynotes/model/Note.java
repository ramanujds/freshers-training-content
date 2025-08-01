package com.mynotes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Note {
    private int id;
    private String title;
    private String content;

}
