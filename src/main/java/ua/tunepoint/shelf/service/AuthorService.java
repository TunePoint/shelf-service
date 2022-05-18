package ua.tunepoint.shelf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.tunepoint.shelf.data.entity.User;
import ua.tunepoint.shelf.data.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final UserRepository userRepository;

    @Transactional
    public void save(Long id) {
        userRepository.save(new User(id, 0L));
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public List<Long> getPopular(Integer top) {
        return userRepository.getPopular(Pageable.ofSize(top));
    }

    @Transactional
    public void incrementInteractions(Long id) {
        userRepository.incrementInteractions(id);
    }

    @Transactional
    public void decrementInteractions(Long id) {
        userRepository.decrementInteractions(id);
    }

    @Transactional
    public void resetInteractions(Long id) {
        userRepository.resetInteractions(id);
    }

    @Transactional
    public void resetAllInteractions() {
        userRepository.resetAllInteractions();
    }
}
