package com.hooli.todo.repositories;

import com.hooli.todo.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository  extends JpaRepository<Note, Long> {
}
