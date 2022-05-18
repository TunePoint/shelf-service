package ua.tunepoint.shelf.config.props;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "shelf")
public class ShelfConfiguration {

    private String resetInteractionsCron;

    private String updateCron;

    private Integer recommendationSize;

    private Integer popularSize;
}
