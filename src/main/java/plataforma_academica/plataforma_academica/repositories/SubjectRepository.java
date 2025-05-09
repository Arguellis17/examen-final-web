package plataforma_academica.plataforma_academica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import plataforma_academica.plataforma_academica.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    boolean existsByTitle(String title);
}
