package com.emids.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emids.Dao.EmpDao;
import com.emids.daoImpln.CommonDaoImpln;
import com.emids.empDTO.City;
import com.emids.empDTO.Country;
import com.emids.empDTO.Department;
import com.emids.empDTO.State;

/**
 * Servlet implementation class NewEmpServlet
 */
@WebServlet(name = "NewEmpServlet", urlPatterns = { "/newEmp" })
public class NewEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewEmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmpDao empDao = new CommonDaoImpln();
		
		

		List<Department> deptList = empDao.getAllDepartments();
		List<Country> countryList = empDao.getAllCountries();
		List<State> stateList = empDao.getAllStates();
		List<City> cityList = empDao.getAllCities();

		request.setAttribute("deptlist", deptList);
		request.setAttribute("countrylist", countryList);
		request.setAttribute("statelist", stateList);
		request.setAttribute("citylist", cityList);

		request.getRequestDispatcher("employee/newEmployee.jsp").forward(request, response);
	}

}
