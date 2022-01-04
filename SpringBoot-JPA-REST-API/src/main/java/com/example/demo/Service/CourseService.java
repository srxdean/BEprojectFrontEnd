package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.CourseRepo.CourseRepo;
import com.example.demo.model.Course;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepo repo;
	
	public List<Course> getc() 
	{		
		return repo.findAll();
	}

	public Course addc(Course c)
	{
		return repo.save(c);
	}
	
	public Optional<Course> getbyid(int cid)
	{
		return repo.findById(cid);
	}
	
	public String updatecourse(Course c, int cid) 
	{
		
		Course course = repo.getById(cid);
		if(course == null) 
		{
			return "No Such object exists";
		}
		
		else 
		{
			course.setName(c.getName());
			repo.save(course);
			return "Success";
		}
			
	}
	
	public String deletecourse(int id) {
		repo.deleteById(id);
		if(repo.existsById(id))
		{
			return "Error deleting the course";
		}
		else
			return "Successfully deleted";
		
	}
}
