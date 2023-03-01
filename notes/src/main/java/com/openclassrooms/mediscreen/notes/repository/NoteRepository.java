package com.openclassrooms.mediscreen.notes.repository;

import com.openclassrooms.mediscreen.notes.entity.Note;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, Integer> {


    List<Note> getAllByPatId(int patId);
    boolean existsByPatId(int patId);


    List<Note> findByName(String lastName, String firstName);
}
