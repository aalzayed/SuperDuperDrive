package com.udacity.jwdnd.course1.cloudstorage.services;


import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    public List<Note> getNotes(int userid){
        return noteMapper.getNotes(userid);
    }

    public void add(Note note, int userId){
        Note newNote = new Note();
        newNote.setUserid(userId);
        newNote.setNotedescription(note.getNotedescription());
        newNote.setNotetitle(note.getNotetitle());

        noteMapper.insertNote(newNote);
    }

    public void edit(Note note) {
        noteMapper.updateNote(note);
    }

    public void delete(int noteId){
        noteMapper.deleteNote(noteId);
    }
}
