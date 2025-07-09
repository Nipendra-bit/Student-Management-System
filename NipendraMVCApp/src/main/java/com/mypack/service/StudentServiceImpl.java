package com.mypack.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mypack.model.Student;
import com.mypack.repository.StudentRepository;
import com.mypack.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	//dependency
	StudentRepository repository;
	
	
	public StudentServiceImpl(StudentRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	public List<Student> getAllStudents() {
		return repository.findAll();
	}


	@Override
	public Student saveStudent(Student s) {
		return repository.save(s);
	}


	@Override
	public Student findById(Long id) {
		return repository.findById(id).get();
	}


	@Override
	public Student updateStudent(Student s) {
		return repository.save(s);
	}


	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
