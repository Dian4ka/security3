package edu.pzks.security25.api.v1.controller;
import edu.pzks.security25.api.v1.request.LoanRequest;
import edu.pzks.security25.domain.entity.Loan;
import edu.pzks.security25.domain.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {
    private final LoanService loans;
    public LoanController(LoanService loans){ this.loans = loans; }

    @PostMapping("/borrow")
    public ResponseEntity<Loan> borrow(@Validated @RequestBody LoanRequest req){
        String userEmail = "user@example.com"; // TODO: from SecurityContext
        return ResponseEntity.ok(loans.borrow(userEmail, req));
    }

    @PostMapping("/{loanId}/return")
    public ResponseEntity<Loan> returnBook(@PathVariable UUID loanId){
        String userEmail = "user@example.com"; // TODO: from SecurityContext
        return ResponseEntity.ok(loans.returnBook(userEmail, loanId));
    }
}
