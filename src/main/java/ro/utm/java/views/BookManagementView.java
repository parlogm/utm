package ro.utm.java.views;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import ro.utm.java.entities.Books;
import ro.utm.java.service.BookService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name="bookManagementView")
@ViewScoped
public class BookManagementView implements Serializable {

    private List<Books> books;

    @ManagedProperty("#{bookService}")
    @Autowired
    private BookService bookService;

    private String name;
    private String author;
    private String domain;
    private int available;

    private Books selectedBook;

    public BookManagementView() {
    }

    @PostConstruct
    public void init() {
        books = bookService.getAllBooks();
        selectedBook = new Books();
    }

    public void onAddNew() {
        // Add one new user to the db & table
        Books newBook= new Books(name, author, domain, available);
        bookService.saveBook(newBook);
        Books newlyAddedBook = bookService.findBookByTitle(name);
        books.add(newlyAddedBook);
        FacesMessage msg = new FacesMessage("New book added", newlyAddedBook.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        RequestContext.getCurrentInstance().execute("PF('dlgb2').hide();PF('cellBooks').addRow();");
    }

    public void updateSelected() {
        bookService.updateBook(selectedBook);
        selectedBook = null;
    }

    public void deleteBook(Books book) {
        books.remove(book);
        bookService.removeBook(book);
        selectedBook = null;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public Books getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(Books selectedBook) {
        this.selectedBook = selectedBook;
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
}
