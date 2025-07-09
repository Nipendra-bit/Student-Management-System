package com.mypack.service;

import java.util.List;

import com.mypack.model.Student;

public interface StudentService {

	List<Student> getAllStudents();
	
	Student saveStudent(Student s);
	
	Student findById(Long id);
	
	Student updateStudent(Student s);
	
	void deleteById(Long id);
}
