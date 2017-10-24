package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentRepository studentRepo;

	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Iterable<Student> list() {
		studentRepo.save(new Student("michael","male"));
		studentRepo.save(new Student("lisa","female"));
		return this.studentRepo.findAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		studentRepo.save(student);
		return new ResponseEntity<String>("Product saved successfully", HttpStatus.OK);
	}

}
