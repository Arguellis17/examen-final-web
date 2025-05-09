package plataforma_academica.plataforma_academica.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plataforma_academica.plataforma_academica.model.Evaluation;
import plataforma_academica.plataforma_academica.repositories.EvaluationRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluationServiceImpl implements EvaluationService {

    private final EvaluationRepository evaluationRepository;

    @Override
    public List<Evaluation> findAll() {
        return evaluationRepository.findAll();
    }

    @Override
    public Evaluation findById(Long id) {
        return evaluationRepository.findById(id).orElse(null);
    }

    @Override
    public Evaluation save(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    @Override
    public Evaluation update(Long id, Evaluation evaluation) {
        evaluation.setId(id);
        return evaluationRepository.save(evaluation);
    }

    @Override
    public void deleteById(Long id) {
        evaluationRepository.deleteById(id);
    }

    @Override
    public List<Evaluation> findByTitle(String title) {
        return evaluationRepository.findByTitleContaining(title);
    }

    @Override
    public List<Evaluation> findBySubject(Long subjectId) {
        return evaluationRepository.findBySubjectId(subjectId);
    }

    @Override
    public List<Evaluation> findByDateRange(Date startDate, Date endDate) {
        return evaluationRepository.findByEvaluationDateBetween(startDate, endDate);
    }
}