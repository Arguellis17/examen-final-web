package plataforma_academica.plataforma_academica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plataforma_academica.plataforma_academica.model.User;
import plataforma_academica.plataforma_academica.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String role
    ) throws Exception {
        return ResponseEntity.ok(userService.registerUser(name, email, role));
    }

    @PostMapping("/login")
    public ResponseEntity<User> authenticateUser(
            @RequestParam String email,
            @RequestParam String password
    ) throws Exception {
        return ResponseEntity.ok(userService.authenticateUser(email, password));
    }

    @GetMapping("/{id}/profile")
    public ResponseEntity<User> getUserProfile(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(userService.getUserProfile(id));
    }

    @PutMapping("/{id}/profile")
    public ResponseEntity<User> updateUserProfile(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String password
    ) throws Exception {
        return ResponseEntity.ok(userService.updateUserProfile(id, name, password));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws Exception {
        userService.softDeleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
