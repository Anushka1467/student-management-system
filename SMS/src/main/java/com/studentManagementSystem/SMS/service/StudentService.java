package com.studentManagementSystem.SMS.service;

import com.studentManagementSystem.SMS.entity.StudentInfo;
import com.studentManagementSystem.SMS.repository.StudentRepository;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentInfo> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentInfo addStudent(StudentInfo student) {
        return studentRepository.save(student);
    }

    public StudentInfo getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    public StudentInfo updateStudent(StudentInfo student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public List<StudentInfo> searchByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }
}

