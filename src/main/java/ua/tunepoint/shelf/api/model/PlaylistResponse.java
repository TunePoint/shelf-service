package ua.tunepoint.shelf.api.model;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.tunepoint.audio.model.response.payload.PlaylistPayload;
import ua.tunepoint.web.model.CommonResponse;

import java.util.List;

@SuperBuilder
@NoArgsConstructor
public class PlaylistResponse extends CommonResponse<List<PlaylistPayload>> {
}
