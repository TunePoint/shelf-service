package ua.tunepoint.shelf.api;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.tunepoint.security.UserPrincipal;
import ua.tunepoint.shelf.api.model.AudioResponse;
import ua.tunepoint.shelf.api.model.PlaylistResponse;
import ua.tunepoint.shelf.api.model.UserResponse;
import ua.tunepoint.shelf.config.props.ShelfConfiguration;
import ua.tunepoint.shelf.service.AudioService;
import ua.tunepoint.shelf.service.AudioShelfElementService;
import ua.tunepoint.shelf.service.AuthorService;
import ua.tunepoint.shelf.service.AuthorShelfElementService;
import ua.tunepoint.shelf.service.PlaylistService;
import ua.tunepoint.shelf.service.PlaylistShelfElementService;
import ua.tunepoint.shelf.service.domain.AudioDomainService;
import ua.tunepoint.shelf.service.domain.PlaylistDomainService;
import ua.tunepoint.shelf.service.domain.UserDomainService;

@RestController
@RequestMapping("/shelf")
@RequiredArgsConstructor
public class ShelfController {

    private final ShelfConfiguration configuration;

    private final AudioShelfElementService audioShelfElementService;
    private final AudioService audioService;
    private final AudioDomainService audioDomainService;

    private final PlaylistShelfElementService playlistShelfElementService;
    private final PlaylistService playlistService;
    private final PlaylistDomainService playlistDomainService;

    private final AuthorShelfElementService authorShelfElementService;
    private final AuthorService authorService;
    private final UserDomainService userDomainService;

    @GetMapping("/popular/audios")
    public AudioResponse getPopularAudios() {
        var ids = audioService.getPopular(configuration.getPopularSize());
        return AudioResponse.builder().payload(audioDomainService.searchBulk(ids)).build();
    }

    @GetMapping("/popular/playlists")
    public PlaylistResponse getPopularPlaylists() {
        var ids = playlistService.getPopular(configuration.getPopularSize());
        return PlaylistResponse.builder().payload(playlistDomainService.searchBulk(ids)).build();
    }

    @GetMapping("/popular/authors")
    public UserResponse getPopularAuthors() {
        var ids = authorService.getPopular(configuration.getPopularSize());
        return UserResponse.builder().payload(userDomainService.searchBulk(ids)).build();
    }

    @GetMapping("/audios")
    @PreAuthorize("isAuthenticated()")
    public AudioResponse getShelfAudios(@AuthenticationPrincipal UserPrincipal user) {
        var ids = audioShelfElementService.getShelfItems(user.getId());
        return AudioResponse.builder().payload(audioDomainService.searchBulk(ids)).build();
    }

    @GetMapping("/authors")
    @PreAuthorize("isAuthenticated()")
    public UserResponse getShelfAuthors(@AuthenticationPrincipal UserPrincipal user) {
        var ids = authorShelfElementService.getShelfItems(user.getId());
        return UserResponse.builder().payload(userDomainService.searchBulk(ids)).build();
    }

    @GetMapping("/playlists")
    @PreAuthorize("isAuthenticated()")
    public PlaylistResponse getShelfPlaylists(@AuthenticationPrincipal UserPrincipal user) {
        var ids = playlistShelfElementService.getShelfItems(user.getId());
        return PlaylistResponse.builder().payload(playlistDomainService.searchBulk(ids)).build();
    }
}
