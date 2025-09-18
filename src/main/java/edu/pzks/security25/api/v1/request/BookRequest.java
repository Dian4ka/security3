package edu.pzks.security25.api.v1.request;
import jakarta.validation.constraints.*;
public class BookRequest {
    @NotBlank public String isbn;
    @NotBlank public String title;
    @NotBlank public String author;
    @Min(1) public int totalCopies = 1;
}
