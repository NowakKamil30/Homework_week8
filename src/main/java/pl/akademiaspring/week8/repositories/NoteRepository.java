package pl.akademiaspring.week8.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.akademiaspring.week8.models.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
