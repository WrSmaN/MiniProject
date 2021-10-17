package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class GroupDetails {
	@Id
	@GeneratedValue
	private int id;
	private String groupName;
	private LocalDate visitDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Employee employee;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Customer> listOfItems;
	
	public GroupDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroupDetails(int id, String groupName, LocalDate visitDate, Employee employee, List<Customer> listOfItems) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.visitDate = visitDate;
		this.employee = employee;
		this.listOfItems = listOfItems;
	}
	public GroupDetails(String groupName, LocalDate visitDate, Employee employee, List<Customer> listOfItems) {
		super();
		this.groupName = groupName;
		this.visitDate = visitDate;
		this.employee = employee;
		this.listOfItems = listOfItems;
	}
	public GroupDetails(String groupName, LocalDate visitDate, Employee employee) {
		super();
		this.groupName = groupName;
		this.visitDate = visitDate;
		this.employee = employee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public LocalDate getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<Customer> getListOfItems() {
		return listOfItems;
	}
	public void setListOfItems(List<Customer> listOfItems) {
		this.listOfItems = listOfItems;
	}
	@Override
	public String toString() {
		return "GroupDetails [id=" + id + ", groupName=" + groupName + ", visitDate=" + visitDate + ", employee="
				+ employee + ", listOfItems=" + listOfItems + "]";
	}
	
	

}
