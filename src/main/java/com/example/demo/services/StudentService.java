package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}
	public List<Student> addStudents(List<Student> students){
		return studentRepo.saveAll(students);
	}
	public Student getStudentById(int id) {
		return studentRepo.findById(id).orElse(null);
	}
	public List<Student> getAll(){
		return studentRepo.findAll();
	}
	public String deleteStudent(int id) {
		 studentRepo.deleteById(id);
		 return "Deleted :"+ id;
	}
	public Student updateStudent(Student student) {
		Student existingStudent = studentRepo.findById(student.getId()).orElse(null);
		existingStudent.setName(student.getName());
		existingStudent.setRollNo(student.getRollNo());
		existingStudent.setSchoolName(student.getSchoolName());
		existingStudent.setStandard(student.getStandard());
		return studentRepo.save(existingStudent);
	}
}
