// test
package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="customers")

public class Customer {
	@Id
	@GeneratedValue
	private int custGroupID;
	private int groupSize;
	private LocalDate visitDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Employee employee;
	
	public Customer() {
		super();
	}
	
	public Customer(int custGroupID, int groupSize, LocalDate visitDate, Employee employee) {
		super();
		this.custGroupID = custGroupID;
		this.groupSize = groupSize;
		this.visitDate = visitDate;
		this.employee = employee;
	}
	public Customer(int groupSize, LocalDate visitDate, Employee employee) {
		super();
		this.groupSize = groupSize;
		this.visitDate = visitDate;
		this.employee = employee;
	}
	
	
	public int getCustGroupID() {
		return custGroupID;
	}
	public void setCustGroupID(int custGroupID) {
		this.custGroupID = custGroupID;
	}
	public int getGroupSize() {
		return groupSize;
	}
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
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

	
	@Override
	public String toString() {
		return "Customer [custGroupID=" + custGroupID + ", groupSize=" + groupSize + ", visitDate=" + visitDate
				+ ", allAccessPass=" + "]";
	}
	
	public String returnCustomerDetails() {
		return this.custGroupID + ": " + this.groupSize + ": " + this.visitDate;
	}
	
}