package ua.tunepoint.shelf.data.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ua.tunepoint.shelf.data.entity.Playlist;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    @Query("SELECT id FROM Playlist WHERE isPrivate = false ORDER BY interactions DESC")
    List<Long> getPopular(Pageable pageable);

    @Modifying
    @Query("UPDATE Playlist SET interactions = interactions + 1 WHERE id = :id")
    void incrementInteractions(Long id);

    @Modifying
    @Query("UPDATE Playlist SET interactions = interactions - 1 WHERE id = :id")
    void decrementInteractions(Long id);

    @Modifying
    @Query("UPDATE Playlist SET interactions = 0 WHERE id = :id")
    void resetInteractions(Long id);

    @Modifying
    @Query("UPDATE Playlist SET interactions = sqrt(interactions)")
    void resetAllInteractions();

    @Modifying
    @Query("UPDATE Playlist SET isPrivate = :isPrivate WHERE id = :id")
    void update(Long id, Boolean isPrivate);
}
