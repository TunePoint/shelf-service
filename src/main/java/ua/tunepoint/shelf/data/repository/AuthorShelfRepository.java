package ua.tunepoint.shelf.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tunepoint.shelf.data.entity.AuthorShelf;

public interface AuthorShelfRepository extends JpaRepository<AuthorShelf, Long> {
}
