package ua.tunepoint.shelf.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ua.tunepoint.shelf.data.entity.AudioShelfElement;
import ua.tunepoint.shelf.data.entity.AudioShelfElementId;

import java.util.List;

public interface AudioShelfElementRepository extends JpaRepository<AudioShelfElement, AudioShelfElementId> {

    @Modifying
    @Query("DELETE FROM AudioShelfElement WHERE id.shelfId = :shelfId")
    void deleteAllByShelfId(Long shelfId);

    @Query(
            "SELECT a.id.audioId FROM AudioShelfElement a " +
            "LEFT JOIN Audio entity ON entity.id = a.id.audioId " +
            "WHERE a.id.shelfId = :shelfId AND entity.isPrivate = false"
    )
    List<Long> findItemsByShelfId(Long shelfId);
}
