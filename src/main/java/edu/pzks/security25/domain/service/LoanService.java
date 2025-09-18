package edu.pzks.security25.domain.service;
import edu.pzks.security25.domain.entity.Loan;
import edu.pzks.security25.api.v1.request.LoanRequest;
import java.util.UUID;
public interface LoanService {
    Loan borrow(String userEmail, LoanRequest req);
    Loan returnBook(String userEmail, UUID loanId);
}
