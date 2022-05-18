package ua.tunepoint.shelf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.tunepoint.shelf.data.entity.AuthorShelfElement;
import ua.tunepoint.shelf.data.entity.AuthorShelfElementId;
import ua.tunepoint.shelf.data.repository.AuthorShelfElementRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorShelfElementService {

    private final AuthorShelfElementRepository shelfElementRepository;

    @Transactional
    public void updateShelf(Long shelfId, List<Long> audios) {

        shelfElementRepository.deleteAllByShelfId(shelfId);
        shelfElementRepository.saveAll(
                audios.stream()
                        .map(it -> new AuthorShelfElement(new AuthorShelfElementId(shelfId, it)))
                        .collect(Collectors.toList())
        );
    }

    public List<Long> getShelfItems(Long shelfId) {
        return shelfElementRepository.findItemsByShelfId(shelfId);
    }
}
