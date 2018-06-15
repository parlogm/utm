package ro.utm.java.service;

import ro.utm.java.entities.Books;

import java.util.List;

public interface BookService {

    List<Books> getAllBooks();
    void saveBook(Books book);
    Books findBookByTitle(String title);
    void updateBook(Books book);
    void removeBook(Books book);

}
