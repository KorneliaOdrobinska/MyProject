package pl.odrobinska.projekt;

public class Kitchen extends Place{
    private Type type;

    public Kitchen( String element, String link, String description, String author, Type type) {
        super(element, link, description, author);
        this.type = type;

    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

enum Type{
    BIG,
    SMALL,
    BRIGHT,
    DARK
}
