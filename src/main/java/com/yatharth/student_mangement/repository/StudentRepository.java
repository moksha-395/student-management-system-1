package com.yatharth.student_mangement.repository;
import java.util.List;
import com.yatharth.student_mangement.model.Student;

public interface StudentRepository {
	
	int save(Student student);
	int update(Student student);
    Student findById(int id);
    int deleteById(int id);
    List<Student> findAll();

}
