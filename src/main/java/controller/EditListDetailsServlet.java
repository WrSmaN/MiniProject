package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.GroupDetails;
import model.Customer;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GroupDetailsHelper dao = new GroupDetailsHelper();
		
		CustomerHelper lih = new CustomerHelper();
		EmployeeHelper em = new EmployeeHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		GroupDetails groupToUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String employeeName = request.getParameter("employeeName");
		Employee newEmployee = em.findEmployee(employeeName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException e) {
			ld = LocalDate.now();
		}
		
		try {
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<Customer> selectedItemsInList = new ArrayList<Customer>();
			
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Customer c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			groupToUpdate.setListOfItems(selectedItemsInList);
		} catch (NullPointerException e) {
			List<Customer> selectedItemsInList = new ArrayList<Customer>();
			groupToUpdate.setListOfItems(selectedItemsInList);
		}
	groupToUpdate.setGroupName(newListName);
	groupToUpdate.setVisitDate(ld);
	groupToUpdate.setEmployee(newEmployee);
	
	dao.updateList(groupToUpdate);
	
	getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
