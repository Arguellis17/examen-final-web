package plataforma_academica.plataforma_academica.services;

import plataforma_academica.plataforma_academica.model.Evaluation;

import java.util.Date;
import java.util.List;

public interface EvaluationService {
    List<Evaluation> findAll();
    Evaluation findById(Long id);
    Evaluation save(Evaluation evaluation);
    Evaluation update(Long id, Evaluation evaluation);
    void deleteById(Long id);
    List<Evaluation> findByTitle(String title);
    List<Evaluation> findBySubject(Long subjectId);
    List<Evaluation> findByDateRange(Date startDate, Date endDate);
}