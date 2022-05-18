package ua.tunepoint.shelf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.tunepoint.shelf.data.entity.Playlist;
import ua.tunepoint.shelf.data.repository.PlaylistRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    
    private final PlaylistRepository playlistRepository;

    @Transactional
    public void save(Long playlistId, Boolean isPrivate) {
        playlistRepository.save(new Playlist(playlistId, isPrivate, 0L));
    }

    @Transactional
    public void delete(Long playlistId) {
        playlistRepository.deleteById(playlistId);
    }

    public List<Long> getPopular(Integer top) {
        return playlistRepository.getPopular(Pageable.ofSize(top));
    }

    @Transactional
    public void update(Long playlistId, Boolean isPrivate) {
        playlistRepository.update(playlistId, isPrivate);
    }

    @Transactional
    public void incrementInteractions(Long id) {
        playlistRepository.incrementInteractions(id);
    }

    @Transactional
    public void decrementInteractions(Long id) {
        playlistRepository.decrementInteractions(id);
    }

    @Transactional
    public void resetInteractions(Long id) {
        playlistRepository.resetInteractions(id);
    }

    @Transactional
    public void resetAllInteractions() {
        playlistRepository.resetAllInteractions();
    }
}
