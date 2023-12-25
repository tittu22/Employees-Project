package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.entity.Employee;
import com.jsp.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo repo;

	public void setEmployee(int id, String name, int sal) {
		Employee emp=new Employee();
		emp.setEmpId(id);
		emp.setEmpName(name);
		emp.setEmpSal(sal);
		repo.addEmployee(emp);
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees=repo.getAll();
		return employees;
	}
	
	public void updateEmployee(int id, String name, int sal) {
		Employee emp=new Employee();
		emp.setEmpId(id);
		emp.setEmpName(name);
		emp.setEmpSal(sal);
		repo.updateEmp(emp);
	}
	
	public Employee getEmployee(int id) {
		Employee emp=new Employee();
		emp=repo.getEmployee(id);
		return emp;
	}

	public void deleteEmployee(int id) {
		repo.deleteEmp(id);
	}
}