package ua.tunepoint.shelf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.tunepoint.shelf.data.entity.AudioShelfElement;
import ua.tunepoint.shelf.data.entity.AudioShelfElementId;
import ua.tunepoint.shelf.data.repository.AudioShelfElementRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AudioShelfElementService {

    private final AudioShelfElementRepository shelfElementRepository;

    @Transactional
    public void updateShelf(Long shelfId, List<Long> audios) {

        shelfElementRepository.deleteAllByShelfId(shelfId);
        shelfElementRepository.saveAll(
                audios.stream()
                        .map(it -> new AudioShelfElement(new AudioShelfElementId(shelfId, it)))
                        .collect(Collectors.toList())
        );
    }

    public List<Long> getShelfItems(Long shelfId) {
        return shelfElementRepository.findItemsByShelfId(shelfId);
    }
}
