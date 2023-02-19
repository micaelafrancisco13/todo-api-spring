package com.hooli.todo.services;

import com.hooli.todo.DTOs.NoteDTO;
import com.hooli.todo.exceptions.ResourceNotFoundException;
import com.hooli.todo.models.Note;
import com.hooli.todo.repositories.CategoryRepository;
import com.hooli.todo.repositories.NoteRepository;
import com.hooli.todo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public NoteService(NoteRepository noteRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note saveNote(NoteDTO noteDTO) {
        var userId = Long.valueOf(1);
        var categoryId = noteDTO.getCategoryId();
        var user = userRepository.findById(userId).orElseThrow
                (() -> new ResourceNotFoundException("The user with the ID of " + userId + " was not found."));
        var category = categoryRepository.findById(categoryId).orElseThrow
                (() -> new ResourceNotFoundException("The category with the ID of " + categoryId + " was not found."));

        var note = new Note();
        note.setTitle(noteDTO.getTitle());
        note.setDescription(noteDTO.getDescription());
        note.setDateCreated(LocalDateTime.now());
        note.setDateUpdated(LocalDateTime.now());
        note.setUser(user);
        note.setCategory(category);

        return noteRepository.save(note);
    }

    public Note updateNote(Long noteId, NoteDTO noteDTO) {
        var userId = Long.valueOf(1);
        var categoryId = noteDTO.getCategoryId();
        var note = noteRepository.findById(noteId).orElseThrow
                (() -> new ResourceNotFoundException("The note with the ID of " + noteId + " was not found."));
        var user = userRepository.findById(userId).orElseThrow
                (() -> new ResourceNotFoundException("The user with the ID of " + userId + " was not found."));
        var category = categoryRepository.findById(categoryId).orElseThrow
                (() -> new ResourceNotFoundException("The category with the ID of " + categoryId + " was not found."));

        note.setTitle(noteDTO.getTitle());
        note.setDescription(noteDTO.getDescription());
        note.setDateUpdated(LocalDateTime.now());
        note.setUser(user);
        note.setCategory(category);

        return noteRepository.save(note);
    }

    public Note deleteNote(Long noteId) {
        var note = noteRepository.findById(noteId).orElseThrow
                (() -> new ResourceNotFoundException("The note with the ID of " + noteId + " was not found."));
        noteRepository.deleteById(noteId);
        return note;
    }

    public Note getNote(Long noteId) {
        return noteRepository.findById(noteId).orElseThrow
                (() -> new ResourceNotFoundException("The note with the ID of " + noteId + " was not found."));
    }
}