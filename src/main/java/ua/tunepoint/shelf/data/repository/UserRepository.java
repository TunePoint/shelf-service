package ua.tunepoint.shelf.data.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ua.tunepoint.shelf.data.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u.id FROM User u ORDER BY u.interactions DESC")
    List<Long> getPopular(Pageable pageable);

    @Modifying
    @Query("UPDATE User SET interactions = interactions + 1 WHERE id = :id")
    void incrementInteractions(Long id);

    @Modifying
    @Query("UPDATE User SET interactions = interactions - 1 WHERE id = :id")
    void decrementInteractions(Long id);

    @Modifying
    @Query("UPDATE User SET interactions = 0 WHERE id = :id")
    void resetInteractions(Long id);

    @Modifying
    @Query("UPDATE User SET interactions = sqrt(interactions)")
    void resetAllInteractions();
}
