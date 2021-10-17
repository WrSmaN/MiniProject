package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Customer;

public class CustomerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebShoppingListwithShoppers");
	
	public void insertItem(Customer li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Customer> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<Customer> allItems = em.createQuery("SELECT i from Customer i").getResultList();
		return allItems;
		
	}

	public void deleteItem(Customer toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Customer> typedQuery = em.createQuery("select li from Customer li where li.groupSize = :selectedGroupSize and li.visitDate = :selectedVisitDate", Customer.class);
		
		typedQuery.setParameter("selectedCompany", toDelete.getGroupSize());
		typedQuery.setParameter("selectedExport", toDelete.getVisitDate());
		
		typedQuery.setMaxResults(1);
		
		Customer result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Customer searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Customer found = em.find(Customer.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(Customer toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Customer> searchForItemByGroupSize(String companyName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Customer> typedQuery = em.createQuery("select li from Customer li where li.groupSize = :selectedGroupSize", Customer.class);
		
		typedQuery.setParameter("selectedCompany", companyName);
		
		List<Customer> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Customer> searchForItemByVisitDate(String exportName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Customer> typedQuery = em.createQuery("select li from Customer li where li.visitDate = :selectedVisitDate", Customer.class);
		
		typedQuery.setParameter("selectedExport", exportName);
		
		List<Customer> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}