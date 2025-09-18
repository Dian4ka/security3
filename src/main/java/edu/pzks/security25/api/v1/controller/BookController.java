package edu.pzks.security25.api.v1.controller;
import edu.pzks.security25.api.v1.request.BookRequest;
import edu.pzks.security25.domain.entity.Book;
import edu.pzks.security25.domain.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService books;
    public BookController(BookService books){ this.books = books; }

    @PostMapping
    public ResponseEntity<Book> create(@Validated @RequestBody BookRequest req){
        return ResponseEntity.ok(books.create(req));
    }

    @GetMapping
    public ResponseEntity<List<Book>> list(){ return ResponseEntity.ok(books.list()); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){ books.delete(id); return ResponseEntity.noContent().build(); }
}
