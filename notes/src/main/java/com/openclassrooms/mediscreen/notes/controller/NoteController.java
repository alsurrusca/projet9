package com.openclassrooms.mediscreen.notes.controller;

import com.openclassrooms.mediscreen.notes.entity.Note;
import com.openclassrooms.mediscreen.notes.service.NotesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class NoteController {

    private static final Logger log = LogManager.getLogger("NoteController");
    @Autowired
    private NotesService notesService;


    @GetMapping(value = "/note/list")
    public String list(@RequestParam String lastName, @RequestParam String firstName, Model model){
        model.addAttribute("notes", notesService.getAllPatientNotes(lastName,firstName));
        return "note/list";
    }
    /**
    @GetMapping(value = "/note/{lastName,firstName}")
    public List<Note> getNote(@PathVariable("lastName,firstName")String lastName, String firstName){
        return notesService.getAllPatientNotes(lastName, firstName);
    }
    */
    
}
