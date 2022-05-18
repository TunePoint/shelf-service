package ua.tunepoint.shelf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.tunepoint.shelf.data.entity.PlaylistShelfElement;
import ua.tunepoint.shelf.data.entity.PlaylistShelfElementId;
import ua.tunepoint.shelf.data.repository.PlaylistShelfElementRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaylistShelfElementService {

    private final PlaylistShelfElementRepository shelfElementRepository;

    @Transactional
    public void updateShelf(Long shelfId, List<Long> audios) {

        shelfElementRepository.deleteAllByShelfId(shelfId);
        shelfElementRepository.saveAll(
                audios.stream()
                        .map(it -> new PlaylistShelfElement(new PlaylistShelfElementId(shelfId, it)))
                        .collect(Collectors.toList())
        );
    }

    public List<Long> getShelfItems(Long shelfId) {
        return shelfElementRepository.findItemsByShelfId(shelfId);
    }
}
