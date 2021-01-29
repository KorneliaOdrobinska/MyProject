package pl.odrobinska.projekt;

public class Hall extends Place{
    private Boolean stairs;

    public Boolean getStairs() {
        return stairs;
    }

    public Hall(Integer id, String element, String link, String description, String author, Boolean stairs) {
        super(id, element, link, description, author);
        this.stairs = stairs;
    }
}
