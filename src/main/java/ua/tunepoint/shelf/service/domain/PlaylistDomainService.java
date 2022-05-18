package ua.tunepoint.shelf.service.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ua.tunepoint.audio.model.response.payload.PlaylistPayload;
import ua.tunepoint.shelf.service.domain.client.PlaylistClient;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaylistDomainService {

    private final PlaylistClient playlistClient;

    public List<PlaylistPayload> searchBulk(List<Long> ids) {
        var response = playlistClient.searchBulk(ids);
        if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null) {
            MDC.put("ResponseCode", response.getStatusCode().toString());
            log.warn("Bad response from playlist service");
            return null;
        }

        return response.getBody().getPayload();
    }
}
