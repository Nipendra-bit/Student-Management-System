package com.mypack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.mypack.model.Student;
import com.mypack.service.StudentService;


@Controller
public class StudentController {

	
	//dependency of controller
	StudentService service;
	
	
	public StudentController(StudentService service) {
		super();
		this.service = service;
	}


	@GetMapping("/students")
	public String fetchAllStudents(Model model)
	{
		System.out.println("fetchall invoked");
		model.addAttribute("students",service.getAllStudents());
		return "studentlist";
	}
	
	@GetMapping("/student/new")
	public String showNewForm(Model model)
	{
		System.out.println("showNewform invoked");
		Student student=new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute Student student)
	{
		System.out.println("saveStudent invoked");
		service.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/student/edit/{id}")
	public String editStudent(@PathVariable Long id,Model model)
	{
		System.out.println("editStudent invoked");
		model.addAttribute("student", service.findById(id));
		return "edit_student";
	}
	
	@PostMapping("/student/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute Student student)
	{
		System.out.println("update invoked....");
		Student existingstudent=service.findById(id);
		existingstudent.setFirstName(student.getFirstName());
		existingstudent.setLastName(student.getLastName());
		existingstudent.setEmail(student.getEmail());
		
		service.updateStudent(existingstudent);
		return "redirect:/students";
	}
	
	@GetMapping("/student/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		service.deleteById(id);
		return "redirect:/students";
	}
	
}
