package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	public StudentService studentService;
	
	@GetMapping("/student/{id}")
	public Student findStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}
	@GetMapping("/students")
	public List<Student> findAllStudents(){
		return studentService.getAll();
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@PostMapping("/addStudents")
	public List<Student> addStudents(@RequestBody List<Student> students){
		return studentService.addStudents(students);
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}

	
}
