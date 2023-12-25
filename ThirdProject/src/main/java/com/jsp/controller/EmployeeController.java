package com.jsp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.entity.Employee;
import com.jsp.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;

//	@RequestMapping("/add-employee")
//	public String register(HttpServletResponse response, HttpServletRequest request) {
//		int id = Integer.parseInt(request.getParameter("id"));
//		String name = request.getParameter("name");
//		int sal = Integer.parseInt(request.getParameter("sal"));
//		service.setEmployee(id, name, sal);
//		return "Display.jsp";
//	}

	@RequestMapping(value = "/add-employee/{id}/{name}/{sal}", method = RequestMethod.GET)
	public ModelAndView display(@PathVariable int id, @PathVariable String name, @PathVariable int sal) {
		service.setEmployee(id, name, sal);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/ThirdProject/Display.jsp");
		return mav;
	}

	@RequestMapping("/get-all")
	public ModelAndView getEmp(HttpServletRequest request, HttpServletResponse response) {
		List<Employee> employees = service.getAllEmployees();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("emp", employees);
		return mav;
	}
}
