package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CourseRepo.CourseRepo;
import com.example.demo.Service.CourseService;
import com.example.demo.model.Course;


@RestController
public class CourseController {

	@Autowired
	private CourseService service;
	
	
	@GetMapping("/courses")
	
	public List<Course> getCourses()
	{
		return service.getc();
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)
	{
		return service.addc(course);
		 
	}
	
	@GetMapping("/courses/{cid}")
	public Optional<Course> getcourse(@PathVariable("cid") Integer cid )
	{
		return service.getbyid(cid);
	}
	
	@PutMapping("/courses/{cid}")
	public String putcourse(@PathVariable("cid") Integer cid,@RequestBody Course course2)
	{
		return service.updatecourse(course2, cid);
		
	}
	
	@DeleteMapping("/courses/{cid}")
	public String deletecourse(@PathVariable("cid") Integer cid)
	{
		return service.deletecourse(cid);	
	}
}
