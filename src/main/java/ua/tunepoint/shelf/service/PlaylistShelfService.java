package ua.tunepoint.shelf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.tunepoint.shelf.data.entity.PlaylistShelf;
import ua.tunepoint.shelf.data.repository.PlaylistShelfRepository;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PlaylistShelfService {

    private final PlaylistShelfRepository shelfRepository;

    public Stream<Long> getAllShelves() {
        return shelfRepository.findAll().stream().map(PlaylistShelf::getId);
    }
}
