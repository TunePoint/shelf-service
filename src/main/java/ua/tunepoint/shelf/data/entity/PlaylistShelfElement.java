package ua.tunepoint.shelf.data.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "playlist_shelf_element")
public class PlaylistShelfElement {

    @EmbeddedId
    private PlaylistShelfElementId id;
}
