package plataforma_academica.plataforma_academica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plataforma_academica.plataforma_academica.model.User;
import plataforma_academica.plataforma_academica.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() throws Exception {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String role
    ) throws Exception {
        User createdUser = userService.registerUser(name, email, role);
        return ResponseEntity.ok(createdUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws Exception {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}