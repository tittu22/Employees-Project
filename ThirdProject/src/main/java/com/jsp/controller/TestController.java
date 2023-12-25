package com.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(value = "/test/{id}/{name}/{sal}",method = RequestMethod.GET)
	public void display(@PathVariable int id,@PathVariable String name,@PathVariable int sal) {
		int empid =id;
		String empname = name;
		int empsal = sal;
		System.out.println(id);
		System.out.println(sal);
		System.out.println(name);
	}
}