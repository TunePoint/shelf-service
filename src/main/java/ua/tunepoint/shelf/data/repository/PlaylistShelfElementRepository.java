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

    @Query(
            "SELECT p.id.playlistId FROM PlaylistShelfElement p " +
            "LEFT JOIN Playlist entity ON entity.id = p.id.playlistId " +
            "WHERE p.id.shelfId = :shelfId AND entity.isPrivate = false"
    )
    List<Long> findItemsByShelfId(Long shelfId);
}
