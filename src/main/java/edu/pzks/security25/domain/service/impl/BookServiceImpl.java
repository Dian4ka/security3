package edu.pzks.security25.domain.service.impl;
import edu.pzks.security25.api.v1.request.BookRequest;
import edu.pzks.security25.domain.entity.Book;
import edu.pzks.security25.domain.repository.BookRepository;
import edu.pzks.security25.domain.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository books;
    public BookServiceImpl(BookRepository books){ this.books = books; }
    @Override public Book create(BookRequest req){
        Book b = new Book();
        b.setIsbn(req.isbn);
        b.setTitle(req.title);
        b.setAuthor(req.author);
        b.setTotalCopies(req.totalCopies);
        b.setAvailableCopies(req.totalCopies);
        return books.save(b);
    }
    @Override public List<Book> list(){ return books.findAll(); }
    @Override public void delete(UUID id){ books.deleteById(id); }
}
