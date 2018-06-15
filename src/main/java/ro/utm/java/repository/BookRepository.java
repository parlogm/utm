package ro.utm.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.utm.java.entities.Books;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Books, Long> {

    Books findByName(String name);

}
