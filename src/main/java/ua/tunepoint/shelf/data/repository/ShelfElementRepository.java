package ua.tunepoint.shelf.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShelfElementRepository<T, ID> extends JpaRepository<T, ID> {

    void deleteAllByShelfId(Long shelfId);

    List<Long> findItemsByShelfId(Long shelfId);
}
