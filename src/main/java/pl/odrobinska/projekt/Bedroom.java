package pl.odrobinska.projekt;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Bedroom")
public class Bedroom extends Place{

    public Bedroom( String element, String link, String description, String author) {
        super( element, link, description, author);
    }



    public Bedroom() {
        super();
    }
}
