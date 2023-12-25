package com.jsp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.entity.Employee;
import com.jsp.service.EmployeeService;

@Controller
public class CRUDController {

	@Autowired
	EmployeeService service;

	@RequestMapping(value = "/fetch-all", method = RequestMethod.GET)
	public ModelAndView getAllEmployees() {
		List<Employee> employees = service.getAllEmployees();
		ModelAndView mav = new ModelAndView();
		mav.addObject("emps", employees);
		mav.setViewName("view-users.jsp");
		return mav;
	}

	@RequestMapping(value = "/add-employee", method = RequestMethod.POST)
	public String register(@RequestParam int id, @RequestParam String name, @RequestParam int sal) {
		service.setEmployee(id, name, sal);
		return "Display.jsp";
	}

	@RequestMapping(value = "/delete-employee", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam int id) {
		service.deleteEmployee(id);
		List<Employee> employees = service.getAllEmployees();
		ModelAndView mav = new ModelAndView();
		mav.addObject("emps", employees);
		mav.setViewName("view-users.jsp");
		return mav;
	}

	@RequestMapping(value = "/updated-employee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@RequestParam int id, @RequestParam String name, @RequestParam int sal) {
		service.updateEmployee(id, name, sal);
		List<Employee> employees = service.getAllEmployees();
		ModelAndView mav = new ModelAndView();
		mav.addObject("emps", employees);
		mav.setViewName("view-users.jsp");
		return mav;
	}

	@RequestMapping(value = "/update-employee", method = RequestMethod.GET)
	public ModelAndView updatePage(@RequestParam int id) {
		Employee emp = service.getEmployee(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("emp", emp);
		mav.setViewName("update-user.jsp");
		return mav;
	}
}
