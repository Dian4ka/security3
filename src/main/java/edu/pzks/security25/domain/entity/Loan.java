package edu.pzks.security25.domain.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "loans")
public class Loan {
    @Id @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Book book;

    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned = false;

    public UUID getId(){ return id; }
    public User getUser(){ return user; }
    public void setUser(User user){ this.user = user; }
    public Book getBook(){ return book; }
    public void setBook(Book book){ this.book = book; }
    public LocalDate getLoanDate(){ return loanDate; }
    public void setLoanDate(LocalDate loanDate){ this.loanDate = loanDate; }
    public LocalDate getDueDate(){ return dueDate; }
    public void setDueDate(LocalDate dueDate){ this.dueDate = dueDate; }
    public boolean isReturned(){ return returned; }
    public void setReturned(boolean returned){ this.returned = returned; }
}
