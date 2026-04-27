package com.jobtracker.demo.controller;

import com.jobtracker.demo.model.User;
import com.jobtracker.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final UserRepository repo;

    public AuthController(UserRepository repo) {
        this.repo = repo;
    }
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        if (repo.findByEmail(user.getEmail()).isPresent()) {
            return "User already exists";
        }

        repo.save(user);
        return "SUCCESS";
    }

    // ✅ Login API (keep this also)
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        Optional<User> existing = repo.findByEmail(user.getEmail());

        if (existing.isPresent() &&
                existing.get().getPassword().equals(user.getPassword())) {
            return "SUCCESS";
        }

        return "FAIL";
    }
}
    // ✅ SIGNUP


