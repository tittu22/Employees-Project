package com.jsp.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.jsp.entity.Employee;

@Repository
public class EmployeeRepo {

	Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
	SessionFactory sf = cfg.buildSessionFactory();

	public void addEmployee(Employee emp) {
		Session s = sf.openSession();
		Transaction trans = s.beginTransaction();
		s.save(emp);
		trans.commit();
		s.close();
	}

	public Employee getEmployee(int id) {
		Session s = sf.openSession();
		Transaction trans = s.beginTransaction();
		Employee emp = s.get(Employee.class, id);
		trans.commit();
		s.close();
		return emp;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		Session s = sf.openSession();
		Transaction trans = s.beginTransaction();
		Query query = s.createQuery("from Employee");
		List<Employee> emps = query.getResultList();
		trans.commit();
		s.close();
		return emps;
	}

	public void deleteEmp(int id) {
		Session s = sf.openSession();
		Transaction trans = s.beginTransaction();
		Employee e = s.get(Employee.class, id);
		s.delete(e);
		trans.commit();
		s.close();
	}

	public void updateEmp(Employee emp) {
		Session s = sf.openSession();
		Transaction trans = s.beginTransaction();
		s.update(emp);
		trans.commit();
		s.close();
	}
}