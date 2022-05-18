package ua.tunepoint.shelf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.tunepoint.shelf.data.entity.AudioShelf;
import ua.tunepoint.shelf.data.repository.AudioShelfRepository;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AudioShelfService {

    private final AudioShelfRepository shelfRepository;

    public Stream<Long> getAllShelves() {
        return shelfRepository.findAll().stream().map(AudioShelf::getId);
    }
}
