package ua.tunepoint.shelf.service.domain.client;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import ua.tunepoint.security.UserContextRequestInterceptor;

public class FeignConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new UserContextRequestInterceptor();
    }
}
