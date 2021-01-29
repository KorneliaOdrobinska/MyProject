package pl.odrobinska.projekt;

import java.util.Date;

abstract class Place {
    protected Integer id;
    protected String element;
    protected String link;
    protected String description;
    protected String author;
    protected Date date;

    public Integer getId() {
        return id;
    }

    public String getElement() {
        return element;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }
}
