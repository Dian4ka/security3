package edu.pzks.security25.domain.repository;
import edu.pzks.security25.domain.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;
public interface LoanRepository extends JpaRepository<Loan, UUID> {
    List<Loan> findByUser_EmailAndReturnedFalse(String email);
}
