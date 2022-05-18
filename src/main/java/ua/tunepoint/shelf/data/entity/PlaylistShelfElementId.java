package ua.tunepoint.shelf.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistShelfElementId implements Serializable {

    @Column(name = "shelf_id")
    private Long shelfId;

    @Column(name = "playlist_id")
    private Long playlistId;
}
