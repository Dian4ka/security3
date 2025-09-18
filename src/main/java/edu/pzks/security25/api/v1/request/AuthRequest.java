package edu.pzks.security25.api.v1.request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public class AuthRequest {
    @Email @NotBlank public String email;
    @NotBlank public String password;
}
