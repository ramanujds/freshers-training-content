package com.mynotes.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.time.LocalDateTime;


@Data
public class Note {
    @Id
    @Field("_id")
    private BigInteger id;
    private String title;
    private String content;
    private LocalDateTime creationTime;

}
