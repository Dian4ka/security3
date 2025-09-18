package edu.pzks.security25.domain.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book {
    @Id @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String title;

    private String author;

    @Column(nullable = false)
    private int totalCopies = 1;

    @Column(nullable = false)
    private int availableCopies = 1;

    public UUID getId(){ return id; }
    public String getIsbn(){ return isbn; }
    public void setIsbn(String isbn){ this.isbn = isbn; }
    public String getTitle(){ return title; }
    public void setTitle(String title){ this.title = title; }
    public String getAuthor(){ return author; }
    public void setAuthor(String author){ this.author = author; }
    public int getTotalCopies(){ return totalCopies; }
    public void setTotalCopies(int totalCopies){ this.totalCopies = totalCopies; }
    public int getAvailableCopies(){ return availableCopies; }
    public void setAvailableCopies(int availableCopies){ this.availableCopies = availableCopies; }
}
