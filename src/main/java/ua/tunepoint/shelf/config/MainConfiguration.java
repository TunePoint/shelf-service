package ua.tunepoint.shelf.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.tunepoint.shelf.config.props.ShelfConfiguration;
import ua.tunepoint.shelf.service.domain.client.DomainFeignMarker;
import ua.tunepoint.shelf.service.recommendation.client.RecommendationFeignMarker;
import ua.tunepoint.web.exception.WebExceptionHandler;

@EnableCaching
@Configuration
@EnableFeignClients(basePackageClasses = {DomainFeignMarker.class, RecommendationFeignMarker.class})
@EnableConfigurationProperties({ShelfConfiguration.class})
public class MainConfiguration {

    @Bean
    public WebExceptionHandler exceptionHandler() {
        return new WebExceptionHandler();
    }
}
