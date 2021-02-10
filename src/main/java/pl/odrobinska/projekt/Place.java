package pl.odrobinska.projekt;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
abstract class Place {
    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")
    protected Integer id;
    protected String element;
    protected String link;
    protected String description;
    protected String author;
  //  protected Date date;

    public Place() {
    }

    public Place(Integer id, String element, String link, String description, String author) {
        this.id = id;
        this.element = element;
        this.link = link;
        this.description = description;
        this.author = author;
    }

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

  /*  public Date getDate() {
        return date;
    }

   */

    public void setAuthor(String author) {
        this.author = author;
    }
}
