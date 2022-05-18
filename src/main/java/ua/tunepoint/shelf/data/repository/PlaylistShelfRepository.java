package ua.tunepoint.shelf.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tunepoint.shelf.data.entity.PlaylistShelf;

public interface PlaylistShelfRepository extends JpaRepository<PlaylistShelf, Long> {
}
