package pl.odrobinska.projekt;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Bedroom")
public class Bedroom extends Place{
    public Bedroom(Integer id, String element, String link, String description, String author) {
        super(id, element, link, description, author);
    }

    public Bedroom() {
        super();
    }
}
