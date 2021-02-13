package pl.odrobinska.projekt;

import javax.persistence.Entity;

@Entity(name = "Hall")
public class Hall extends Place{
    private Boolean stairs;

    public Hall() {
        super();
    }

    public Boolean getStairs() {
        return stairs;
    }

    public Hall(String element, String link, String description, String author, Boolean stairs) {
        super(element, link, description, author);
        this.stairs = stairs;
    }
}
