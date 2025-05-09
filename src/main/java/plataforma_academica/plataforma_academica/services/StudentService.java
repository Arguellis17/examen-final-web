package plataforma_academica.plataforma_academica.services;

import plataforma_academica.plataforma_academica.model.Student;

import java.util.List;

public interface StudentService extends CrudService<Student, Long> {
    List<Student> findByName(String name) throws Exception;
    List<Student> findByEmail(String email) throws Exception;
}