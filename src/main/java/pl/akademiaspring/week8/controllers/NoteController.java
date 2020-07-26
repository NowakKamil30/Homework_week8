package pl.akademiaspring.week8.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.akademiaspring.week8.models.Note;
import pl.akademiaspring.week8.repositories.NoteRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/note")
@CrossOrigin
public class NoteController {

    private NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Long id) {
        return noteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());

    }
    @GetMapping
    public ResponseEntity<List<Note>> getNotes() {
        return Optional.of(noteRepository.findAll())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }
    @PostMapping
    public ResponseEntity<Note> postNote(@RequestBody Note note) {
        return Optional.of(noteRepository.save(note))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Note> putNote(@PathVariable Long id, @RequestBody Note note) {
        note.setId(id);
        return Optional.of(noteRepository.save(note))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
