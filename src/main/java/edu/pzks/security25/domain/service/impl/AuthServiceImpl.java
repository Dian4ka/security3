package edu.pzks.security25.domain.service.impl;
import edu.pzks.security25.api.v1.request.AuthRequest;
import edu.pzks.security25.domain.entity.User;
import edu.pzks.security25.domain.repository.UserRepository;
import edu.pzks.security25.domain.service.AuthService;
import edu.pzks.security25.security.jwt.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository users;
    private final PasswordEncoder encoder;
    private final JwtService jwt;
    public AuthServiceImpl(UserRepository users, PasswordEncoder encoder, JwtService jwt) {
        this.users = users; this.encoder = encoder; this.jwt = jwt;
    }
    @Override public String register(AuthRequest req) {
        if (users.findByEmail(req.email).isPresent()) throw new RuntimeException("User exists");
        User u = new User();
        u.setEmail(req.email);
        u.setPasswordHash(encoder.encode(req.password));
        users.save(u);
        return jwt.issueToken(u.getEmail(), u.getRole().name());
    }
    @Override public String login(AuthRequest req) {
        User u = users.findByEmail(req.email).orElseThrow(() -> new RuntimeException("Not found"));
        if (!encoder.matches(req.password, u.getPasswordHash())) throw new RuntimeException("Bad credentials");
        return jwt.issueToken(u.getEmail(), u.getRole().name());
    }
}
