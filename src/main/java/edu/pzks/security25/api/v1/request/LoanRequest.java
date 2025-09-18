package edu.pzks.security25.api.v1.request;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
public class LoanRequest {
    @NotNull public UUID bookId;
    @NotNull public Integer days; // тривалість позики
}
