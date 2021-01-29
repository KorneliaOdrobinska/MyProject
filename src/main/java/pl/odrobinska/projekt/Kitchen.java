package pl.odrobinska.projekt;

public class Kitchen extends Place{
    private Type type;

    public Kitchen(Integer id, String element, String link, String description, String author, Type type) {
        super(id, element, link, description, author);
        this.type = type;

    }
}

enum Type{
    BIG,
    SMALL,
    BRIGHT,
    DARK
}
