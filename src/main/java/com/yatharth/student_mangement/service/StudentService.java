package com.yatharth.student_mangement.service;

import com.yatharth.student_mangement.model.Student;
import com.yatharth.student_mangement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service                         // ← This tells Spring: "This is a Service bean"
public class StudentService {

    // Spring will automatically inject your repository here
    @Autowired
    private StudentRepository repository;

    // Get all students
    public List<Student> listAll() {
        return repository.findAll();
    }

    // Save or Update (smart method – works for both Add and Edit)
    public void save(Student student) {
        if (student.getId() == 0) {
            // New student → insert
            repository.save(student);
        } else {
            // Existing student → update
            repository.update(student);
        }
    }

    // Get one student by id
    public Student get(int id) {
        return repository.findById(id);
    }

    // Delete student
    public void delete(int id) {
        repository.deleteById(id);
    }
}