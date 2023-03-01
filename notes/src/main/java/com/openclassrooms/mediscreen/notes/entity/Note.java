package com.openclassrooms.mediscreen.notes.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;

@Document(collation = "note")
public class Note {

    @Id
    private int id;

    @Field(name = "patId")
    private int patId;

    @NotBlank(message = "Patient lastname can't be empty")
    @Field(value = "LastName")
    private String lastName;

    @NotBlank(message = "Patient firstName can't be empty")
    @Field(value = "FirstName")
    private String firstName;

    @NotBlank(message = "Notes can't be empty")
    @Field(name = "noteContent")
    private String noteContent;

    public Note(@NotBlank(message = "Patient lastname can't be empty") String lastName, @NotBlank(message = "Patient firstName can't be empty") String firstName, @NotBlank(message = "Notes can't be empty") String noteContent) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.noteContent = noteContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatId() {
        return patId;
    }

    public void setPatId(int patId) {
        this.patId = patId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }


}
