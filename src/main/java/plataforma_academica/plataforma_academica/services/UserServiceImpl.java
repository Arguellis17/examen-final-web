package plataforma_academica.plataforma_academica.services;

import org.springframework.beans.factory.annotation.Autowired;
import plataforma_academica.plataforma_academica.model.RoleEnum;
import plataforma_academica.plataforma_academica.model.User;
import plataforma_academica.plataforma_academica.repositories.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
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
    public void deleteById(Long id) {
        userRepository.deleteById(id);
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
        user.setRole(roleEnum);
        user.setPassword("default_password"); // opcional: generar contraseña temporal

        return userRepository.save(user);
    }
}
