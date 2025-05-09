package plataforma_academica.plataforma_academica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import plataforma_academica.plataforma_academica.model.Evaluation;

import java.util.Date;
import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    List<Evaluation> findByTitleContaining(String title);
    List<Evaluation> findBySubjectId(Long subjectId);
    List<Evaluation> findByEvaluationDateBetween(Date startDate, Date endDate);
}