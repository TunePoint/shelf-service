package ua.tunepoint.shelf.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ua.tunepoint.shelf.data.entity.AuthorShelfElement;
import ua.tunepoint.shelf.data.entity.AuthorShelfElementId;

import java.util.List;

public interface AuthorShelfElementRepository extends JpaRepository<AuthorShelfElement, AuthorShelfElementId> {

    @Modifying
    @Query("DELETE FROM AuthorShelfElement WHERE id.shelfId = :shelfId")
    void deleteAllByShelfId(Long shelfId);

    @Query("SELECT a.id.authorId FROM AuthorShelfElement a WHERE a.id.shelfId = :shelfId")
    List<Long> findItemsByShelfId(Long shelfId);
}
