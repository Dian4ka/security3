package edu.pzks.security25.domain.service;
import edu.pzks.security25.domain.entity.Book;
import edu.pzks.security25.api.v1.request.BookRequest;
import java.util.List;
import java.util.UUID;
public interface BookService {
    Book create(BookRequest req);
    List<Book> list();
    void delete(UUID id);
}
