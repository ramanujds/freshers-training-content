package com.mynotes.repository;


import com.mynotes.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface NotesRepository extends MongoRepository<Note, BigInteger> {


    Note findByTitleIgnoreCase(String title);


}
