package com.openclassrooms.mediscreen.notes.NoteDTO;


import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class NoteDT0 {

    private int id;
    @NotNull
    private int patientId;
    @NotEmpty
    private String noteContent;

    public NoteDT0(int id, @NotNull int patientId, @NotEmpty String noteContent) {
        this.id = id;
        this.patientId = patientId;
        this.noteContent = noteContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
}
