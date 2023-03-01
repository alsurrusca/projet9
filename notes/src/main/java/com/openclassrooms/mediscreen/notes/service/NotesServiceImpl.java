package com.openclassrooms.mediscreen.notes.service;

import com.openclassrooms.mediscreen.notes.entity.Note;
import com.openclassrooms.mediscreen.notes.exceptions.DataNotFoundException;
import com.openclassrooms.mediscreen.notes.repository.NoteRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {

    private static final Logger log = LogManager
            .getLogger("NotesServiceImpl");

    @Autowired
    private NoteRepository noteRepository;

    private static final int MAX_SIZE_ALLOWED_TO_DELETE = 10;

    @Override
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }
    public List<Note> getAllPatientNotes(String lastName, String firstName) {
        List<Note> allPatientNotes = noteRepository.findByName(lastName, firstName);
        if (allPatientNotes.isEmpty()) {
            throw new DataNotFoundException("Notes not found for patient : " + lastName + " " + firstName);
        }
        return allPatientNotes;

    }

    @Override
    public Note getNote(int patId) {
        return noteRepository.findById(patId).orElse(null);
    }

    @Override
    public Note addNotes(Note note) {
        if (note == null) {
            log.info("Note is empty");
        }
        return noteRepository.save(note);
    }

    @Override
    public boolean updateNotes(Note note, int patId) {
        Note existingNote = noteRepository.findById(patId).orElse(null);
        if (existingNote == null) {
            log.error("Unknow note with id : " + patId);
            return false;
        }
        existingNote.setNoteContent(note.getNoteContent());
        noteRepository.save(existingNote);
        return true;
    }
    }


