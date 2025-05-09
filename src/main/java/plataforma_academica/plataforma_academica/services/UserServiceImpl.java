package plataforma_academica.plataforma_academica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import plataforma_academica.plataforma_academica.model.RoleEnum;
import plataforma_academica.plataforma_academica.model.User;
import plataforma_academica.plataforma_academica.repositories.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll()
                .stream().filter(User::isActive).toList();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) throws Exception {
        if (!userRepository.existsById(user.getCodigoUsuario())) {
            throw new Exception("Usuario no encontrado");
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        softDeleteUser(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public User registerUser(String name, String email, String role) throws Exception {
        if (userRepository.existsByEmail(email)) {
            throw new Exception("El correo ya está registrado");
        }

        RoleEnum roleEnum;
        try {
            roleEnum = RoleEnum.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new Exception("Rol inválido: debe ser ADMIN, TEACHER o STUDENT");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder().encode("default_password"));
        user.setRole(roleEnum);
        user.setActive(true);

        return userRepository.save(user);
    }

    @Override
    public User authenticateUser(String email, String password) throws Exception {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        if (!user.isActive()) {
            throw new Exception("Usuario deshabilitado");
        }

        if (!passwordEncoder().matches(password, user.getPassword())) {
            throw new Exception("Contraseña incorrecta");
        }

        // Aquí podrías generar un token JWT si decides usarlo
        return user;
    }

    @Override
    public User getUserProfile(Long userId) throws Exception {
        return userRepository.findById(userId)
                .filter(User::isActive)
                .orElseThrow(() -> new Exception("Usuario no encontrado o desactivado"));
    }

    @Override
    public User updateUserProfile(Long userId, String name, String password) throws Exception {
        User user = getUserProfile(userId);
        user.setName(name);
        user.setPassword(passwordEncoder().encode(password));
        return userRepository.save(user);
    }

    @Override
    public void softDeleteUser(Long userId) throws Exception {
        User user = getUserProfile(userId);
        user.setActive(false);
        userRepository.save(user);
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Para usarlo, incluye spring-boot-starter-security en el pom.xml
    }
}
