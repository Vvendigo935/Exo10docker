package org.example.student.service;

import org.example.student.entity.Student;
import org.example.student.exeption.NotFoundException;
import org.example.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(int id, Student student) {
        Student studentFound = studentRepository.findById(id).orElseThrow(NotFoundException::new);
        Student studentGet = studentRepository.findById(id).orElseThrow(NotFoundException::new);
        studentFound.setId(studentGet.getId());
        studentFound.setFirstName(student.getFirstName());
        studentFound.setLastName(student.getLastName());
        studentFound.setBirthDate(student.getBirthDate());
        return studentRepository.save(studentFound);
    }

        public void delete(int id){
            studentRepository.deleteById(id);
        }

}

