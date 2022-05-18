package ua.tunepoint.shelf.api.model;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.tunepoint.audio.model.response.payload.AudioPayload;
import ua.tunepoint.web.model.CommonResponse;

import java.util.List;

@SuperBuilder
@NoArgsConstructor
public class AudioResponse extends CommonResponse<List<AudioPayload>> {
}
