package edu.pzks.security25.domain.service.impl;
import edu.pzks.security25.api.v1.request.LoanRequest;
import edu.pzks.security25.domain.entity.Book;
import edu.pzks.security25.domain.entity.Loan;
import edu.pzks.security25.domain.entity.User;
import edu.pzks.security25.domain.repository.BookRepository;
import edu.pzks.security25.domain.repository.LoanRepository;
import edu.pzks.security25.domain.repository.UserRepository;
import edu.pzks.security25.domain.service.LoanService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loans;
    private final BookRepository books;
    private final UserRepository users;
    public LoanServiceImpl(LoanRepository loans, BookRepository books, UserRepository users){
        this.loans = loans; this.books = books; this.users = users;
    }
    @Override
    public Loan borrow(String userEmail, LoanRequest req) {
        User u = users.findByEmail(userEmail).orElseThrow();
        Book b = books.findById(req.bookId).orElseThrow();
        if (b.getAvailableCopies() <= 0) throw new RuntimeException("No copies available");
        b.setAvailableCopies(b.getAvailableCopies() - 1);
        books.save(b);
        Loan l = new Loan();
        l.setUser(u); l.setBook(b);
        l.setLoanDate(LocalDate.now());
        l.setDueDate(LocalDate.now().plusDays(req.days));
        l.setReturned(false);
        return loans.save(l);
    }
    @Override
    public Loan returnBook(String userEmail, UUID loanId) {
        User u = users.findByEmail(userEmail).orElseThrow();
        Loan l = loans.findById(loanId).orElseThrow();
        if (!l.getUser().getId().equals(u.getId())) throw new RuntimeException("Forbidden");
        if (!l.isReturned()){
            l.setReturned(true);
            Book b = l.getBook();
            b.setAvailableCopies(b.getAvailableCopies() + 1);
            books.save(b);
        }
        return loans.save(l);
    }
}
