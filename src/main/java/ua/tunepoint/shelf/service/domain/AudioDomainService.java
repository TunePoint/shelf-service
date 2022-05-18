package ua.tunepoint.shelf.service.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ua.tunepoint.audio.model.response.payload.AudioPayload;
import ua.tunepoint.shelf.service.domain.client.AudioClient;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AudioDomainService {

    private final AudioClient audioClient;

    public List<AudioPayload> searchBulk(List<Long> ids) {
        var response = audioClient.searchBulk(ids);
        if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null) {
            MDC.put("ResponseCode", response.getStatusCode().toString());
            log.warn("Bad response from audio service");
            return null;
        }

        return response.getBody().getPayload();
    }
}
