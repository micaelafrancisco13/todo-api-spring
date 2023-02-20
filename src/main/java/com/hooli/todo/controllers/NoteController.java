package com.hooli.todo.controllers;

import com.hooli.todo.DTOs.NoteDTO;
import com.hooli.todo.models.Note;
import com.hooli.todo.services.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "*")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping
    public Note saveNote(@Valid @RequestBody NoteDTO noteDTO) {
        return noteService.saveNote(noteDTO);
    }

    @PutMapping("/{noteId}")
    public Note updateNote(@PathVariable Long noteId, @Valid @RequestBody NoteDTO noteDTO) {
        return noteService.updateNote(noteId, noteDTO);
    }

    @DeleteMapping("/{noteId}")
    public Note deleteNote(@PathVariable Long noteId) {
        return noteService.deleteNote(noteId);
    }

    @GetMapping("/{noteId}")
    public Note getNote(@PathVariable Long noteId) {
        return noteService.getNote(noteId);
    }
}
