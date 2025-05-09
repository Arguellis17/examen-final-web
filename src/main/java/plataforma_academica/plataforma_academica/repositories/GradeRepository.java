package plataforma_academica.plataforma_academica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import plataforma_academica.plataforma_academica.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {

}
