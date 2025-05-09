package plataforma_academica.plataforma_academica.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plataforma_academica.plataforma_academica.model.Student;
import plataforma_academica.plataforma_academica.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() throws Exception {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) throws Exception {
        return studentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) throws Exception {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) throws Exception {
        student.setCodigoUsuario(id);
        return ResponseEntity.ok(studentService.update(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) throws Exception {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/search/name")
    public List<Student> getStudentsByName(@RequestParam String name) throws Exception {
        return studentService.findByName(name);
    }

    @GetMapping("/search/email")
    public List<Student> getStudentsByEmail(@RequestParam String email) throws Exception {
        return studentService.findByEmail(email);
    }


}