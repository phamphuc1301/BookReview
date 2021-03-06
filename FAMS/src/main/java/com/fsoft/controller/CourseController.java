package com.fsoft.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fsoft.entities.Course;
import com.fsoft.services.CourseService;

@Controller
public class CourseController {

	private static final int SIZE = 1;

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public String listCourse(ModelMap modelMap, @RequestParam String page) {
		System.out.println("inside");
		int sizeOfPage = Integer.parseInt(page);
		PageRequest pageRequest = new PageRequest(sizeOfPage, SIZE);
		System.out.println(sizeOfPage);
		System.out.println(pageRequest);
		Page<Course> courses = courseService.findAll(pageRequest);
		Iterator<Course> listOfCourse = courses.iterator();
		modelMap.addAttribute("page", listOfCourse);
		
		return "courses";
	}
}
