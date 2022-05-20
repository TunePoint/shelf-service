package ua.tunepoint.shelf.service.domain.client;

import org.springframework.cloud.openfeign.FeignClient;
import ua.tunepoint.account.api.UserEndpoint;

@FeignClient(name = "account-service", configuration = FeignConfiguration.class)
public interface UserClient extends UserEndpoint {
}
