package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GroupDetails;

public class GroupDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebShoppingListwithShoppers");

	public void insertNewListDetails(GroupDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<GroupDetails> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<GroupDetails> allDetails = em.createQuery("SELECT d FROM GroupDetails d").getResultList();
		return allDetails;
	}

	public GroupDetails searchForListDetailsById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		GroupDetails found = em.find(GroupDetails.class, tempId);
		em.close();
		return found;
	}

	public void deleteList(GroupDetails listToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GroupDetails> typedQuery = em.createQuery("SELECT detail from GroupDetails detail where detail.id= :selectedId", GroupDetails.class);
		typedQuery.setParameter("selectedId", listToDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		GroupDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void updateList(GroupDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}