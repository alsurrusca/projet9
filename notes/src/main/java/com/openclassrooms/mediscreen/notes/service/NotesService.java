package com.openclassrooms.mediscreen.notes.service;

import com.openclassrooms.mediscreen.notes.entity.Note;
import java.util.List;


public interface NotesService {


    List<Note> getAllNotes();

    List<Note> getAllPatientNotes(String lastName, String firstName);


    Note getNote(int id);

    Note addNotes(Note note);

    boolean updateNotes(Note note, int id);
}
