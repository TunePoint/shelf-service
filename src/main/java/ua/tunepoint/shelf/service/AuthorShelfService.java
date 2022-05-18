package ua.tunepoint.shelf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.tunepoint.shelf.data.entity.AuthorShelf;
import ua.tunepoint.shelf.data.repository.AuthorShelfRepository;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AuthorShelfService {

    private final AuthorShelfRepository shelfRepository;

    public Stream<Long> getAllShelves() {
        return shelfRepository.findAll().stream().map(AuthorShelf::getId);
    }
}
