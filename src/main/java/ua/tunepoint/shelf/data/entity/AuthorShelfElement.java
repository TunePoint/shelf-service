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
@Table(name = "author_shelf_element")
public class AuthorShelfElement {

    @EmbeddedId
    private AuthorShelfElementId id;
}
