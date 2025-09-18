package edu.pzks.security25.api.v1.controller;
import edu.pzks.security25.api.v1.request.AuthRequest;
import edu.pzks.security25.api.v1.response.AuthResponse;
import edu.pzks.security25.domain.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService auth;
    public AuthController(AuthService auth){ this.auth = auth; }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Validated @RequestBody AuthRequest req){
        String token = auth.register(req);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Validated @RequestBody AuthRequest req){
        String token = auth.login(req);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
