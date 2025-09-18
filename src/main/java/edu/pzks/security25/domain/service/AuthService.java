package edu.pzks.security25.domain.service;
import edu.pzks.security25.api.v1.request.AuthRequest;
public interface AuthService {
    String register(AuthRequest req);
    String login(AuthRequest req);
}
