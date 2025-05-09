package plataforma_academica.plataforma_academica.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plataforma_academica.plataforma_academica.model.Student;
import plataforma_academica.plataforma_academica.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    // Métodos de CrudService
    @Override
    public List<Student> findAll() throws Exception {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) throws Exception {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) throws Exception {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) throws Exception {
        if (student.getCodigoUsuario() == null || !studentRepository.existsById(student.getCodigoUsuario())) {
            throw new Exception("Estudiante no encontrado");
        }
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() throws Exception {
        studentRepository.deleteAll();
    }

    // Nuevos métodos implementados
    @Override
    public List<Student> findByName(String name) throws Exception {
        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> findByEmail(String email) throws Exception {
        return studentRepository.findByEmail(email);
    }

}