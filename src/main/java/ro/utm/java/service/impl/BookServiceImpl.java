package ro.utm.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utm.java.entities.Books;
import ro.utm.java.repository.BookRepository;
import ro.utm.java.service.BookService;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(Books book) {
        bookRepository.save(book);
    }

    @Override
    public Books findBookByTitle(String title) {
        return bookRepository.findByName(title);
    }

    @Override
    public void updateBook(Books book) {
        bookRepository.save(book);
    }

    @Override
    public void removeBook(Books book) {
        bookRepository.delete(book);
    }
}
