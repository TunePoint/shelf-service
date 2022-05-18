package ua.tunepoint.shelf.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "playlist_shelf")
public class PlaylistShelf {

    @Id
    @Column(name = "id")
    private Long id;
}
