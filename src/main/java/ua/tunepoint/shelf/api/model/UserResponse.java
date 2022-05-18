package ua.tunepoint.shelf.api.model;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.tunepoint.account.model.response.payload.UserPublicPayload;
import ua.tunepoint.web.model.CommonResponse;

import java.util.List;

@SuperBuilder
@NoArgsConstructor
public class UserResponse extends CommonResponse<List<UserPublicPayload>> {
}
