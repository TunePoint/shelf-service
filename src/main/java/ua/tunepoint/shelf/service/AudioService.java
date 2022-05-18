package ua.tunepoint.shelf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.tunepoint.shelf.data.entity.Audio;
import ua.tunepoint.shelf.data.repository.AudioRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AudioService {

    private final AudioRepository audioRepository;

    @Transactional
    public void save(Long audioId, Boolean isPrivate) {
        audioRepository.save(new Audio(audioId, isPrivate, 0L));
    }

    public List<Long> getPopular(Integer top) {
        return audioRepository.getPopular(Pageable.ofSize(top));
    }

    @Transactional
    public void delete(Long audioId) {
        audioRepository.deleteById(audioId);
    }

    @Transactional
    public void update(Long audioId, Boolean isPrivate) {
         audioRepository.update(audioId, isPrivate);
    }

    @Transactional
    public void incrementInteractions(Long id) {
        audioRepository.incrementInteractions(id);
    }

    @Transactional
    public void decrementInteractions(Long id) {
        audioRepository.decrementInteractions(id);
    }

    @Transactional
    public void resetInteractions(Long id) {
        audioRepository.resetInteractions(id);
    }

    @Transactional
    public void resetAllInteractions() {
        audioRepository.resetAllInteractions();
    }
}
