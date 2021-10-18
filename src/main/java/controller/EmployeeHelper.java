package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Employee;

/**
 * @author Ben Sanders - bsanders3
 * CIS 175 Fall 2021
 */
public class EmployeeHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniProject");
	
	public void insertEmployee(Employee e) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Employee> showAllEmployees() {
		EntityManager em = emfactory.createEntityManager();
		List<Employee> allEmployees = em.createQuery("SELECT e FROM Employee e").getResultList();
		return allEmployees;
	}
	
	public Employee findEmployee(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> typedQuery = em.createQuery("select em from Employee em where em.employeeName = :selectedName", Employee.class);
		
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Employee foundEmployee;
		try {
			foundEmployee = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundEmployee = new Employee(nameToLookUp);
		}
		em.close();
		return foundEmployee;
	}
}
