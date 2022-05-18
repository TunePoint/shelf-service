package ua.tunepoint.shelf.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tunepoint.shelf.data.entity.AudioShelf;

public interface AudioShelfRepository extends JpaRepository<AudioShelf, Long> {
}
