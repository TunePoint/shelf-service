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

    @Query("SELECT a.id.audioId FROM AudioShelfElement a WHERE a.id.shelfId = :shelfId")
    List<Long> findItemsByShelfId(Long shelfId);
}
