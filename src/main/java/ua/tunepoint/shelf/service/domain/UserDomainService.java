package ua.tunepoint.shelf.service.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ua.tunepoint.account.model.response.payload.UserPublicPayload;
import ua.tunepoint.shelf.service.domain.client.UserClient;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDomainService {

    private final UserClient userClient;

    public List<UserPublicPayload> searchBulk(List<Long> ids) {
        var response = userClient.searchBulk(ids);
        if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null) {
            MDC.put("ResponseCode", response.getStatusCode().toString());
            log.warn("Bad response from user service");
            return null;
        }

        return response.getBody().getPayload();
    }
}
