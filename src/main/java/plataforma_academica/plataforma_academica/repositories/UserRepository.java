package plataforma_academica.plataforma_academica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plataforma_academica.plataforma_academica.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);
    List<User> findByEmail(String email);
    boolean existsByEmail(String email);

}
