package ro.utm.java.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide book name")
    private String name;

    @Column(name = "author")
    @NotEmpty(message = "*Please provide book author")
    private String author;

    @Column(name = "domain")
    @NotEmpty(message = "*Please provide book domain")
    private String domain;

    @Column(name = "available")
    private int available;

    @ManyToOne
    @JoinTable(name = "leased_books", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private People leasedTo;

    public Books(){

    }

    public Books(String name, String author, String domain, int available) {
        this.name = name;
        this.author = author;
        this.domain = domain;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public People getLeasedTo() {
        return leasedTo;
    }

    public void setLeasedTo(People leasedTo) {
        this.leasedTo = leasedTo;
    }
}
