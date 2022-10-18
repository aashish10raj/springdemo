package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
	//List<Course> list;
	public CourseServiceImpl()
	{
	/*	list=new ArrayList<>();
		list.add(new Course(145, "Java", "test course"));
		list.add(new Course(123, "Java Spring", "demo version"));*/ 
		
	}
	
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		
		//return list;
		return courseDao.findAll();
	}


	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		/*Course c=null;
		for(Course course:list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		return c;*/
		return courseDao.getOne(courseId);
	}


	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		//list.add(course);
		//return course;
		courseDao.save(course);
		return course;
	}

}
