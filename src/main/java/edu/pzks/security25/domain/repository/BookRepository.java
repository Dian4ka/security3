package edu.pzks.security25.domain.repository;
import edu.pzks.security25.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;
public interface BookRepository extends JpaRepository<Book, UUID> {
    Optional<Book> findByIsbn(String isbn);
}
