package org.example.teacher.service;


import org.example.teacher.entity.Teacher;
import org.example.teacher.exeption.NotFoundException;
import org.example.teacher.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;


    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
}

public Teacher getTeacherById(int id) {
        return teacherRepository.findById(id).orElse(null);
}

public Teacher updateTeacher(int id, Teacher teacher) {
        Teacher teacherFound = teacherRepository.findById(id).orElseThrow(NotFoundException::new);
        Teacher teacherGet = teacherRepository.findById(id).orElseThrow(NotFoundException::new);
    teacherFound.setId(teacherGet.getId());
    teacherFound.setFirstName(teacher.getFirstName());
    teacherFound.setLastName(teacher.getLastName());
    teacherFound.setBirthDate(teacher.getBirthDate());
        return teacherRepository.save(teacherFound);
}

        public void delete(int id){
            teacherRepository.deleteById(id);
        }

}
