package ua.tunepoint.shelf.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ua.tunepoint.shelf.data.entity.PlaylistShelfElement;
import ua.tunepoint.shelf.data.entity.PlaylistShelfElementId;

import java.util.List;

public interface PlaylistShelfElementRepository extends JpaRepository<PlaylistShelfElement, PlaylistShelfElementId> {

    @Modifying
    @Query("DELETE FROM PlaylistShelfElement WHERE id.shelfId = :shelfId")
    void deleteAllByShelfId(Long shelfId);

    @Query("SELECT a.id.playlistId FROM PlaylistShelfElement a WHERE a.id.shelfId = :shelfId")
    List<Long> findItemsByShelfId(Long shelfId);
}
