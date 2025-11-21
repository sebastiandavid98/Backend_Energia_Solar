package com.plataformaenergia.backend.controller;

import com.plataformaenergia.backend.dto.AuthRequest;
import com.plataformaenergia.backend.dto.AuthResponse;
import com.plataformaenergia.backend.dto.RegisterRequest;
import com.plataformaenergia.backend.model.User;
import com.plataformaenergia.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // --------- Registro ----------
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest req) {

        // Validar que no exista el correo
        Optional<User> existing = userRepository.findAll()
                .stream()
                .filter(u -> req.getEmail().equalsIgnoreCase(u.getEmail()))
                .findFirst();

        if (existing.isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body(new AuthResponse(null, null));
        }

        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        user.setOwnerId(null);
        user.setTimestamp(LocalDateTime.now());

        User saved = userRepository.save(user);

        // Generar token para el nuevo usuario
        String token = "Bearer_" + saved.getId() + "_" + System.currentTimeMillis();

        AuthResponse resp = new AuthResponse(token, saved);
        return ResponseEntity.ok(resp);
    }

    // --------- Login ----------
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req) {

        Optional<User> userOpt = userRepository.findByEmailAndPassword(
                req.getEmail(),
                req.getPassword()
        );

        if (userOpt.isEmpty()) {
            // credenciales incorrectas
            return ResponseEntity.status(401).body(new AuthResponse(null, null));
        }

        User user = userOpt.get();

        // Token simple (en producción usar JWT real)
        String token = "Bearer_" + user.getId() + "_" + System.currentTimeMillis();

        AuthResponse resp = new AuthResponse(token, user);
        return ResponseEntity.ok(resp);
    }
}
