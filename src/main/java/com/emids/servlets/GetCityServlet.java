package com.emids.servlets;

import static com.emids.common.CommonConst.CITY_NAME;
import static com.emids.common.CommonConst.EMP_NAME;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emids.config.ConnectionProvider;
import com.emids.empDTO.City;
import com.emids.empDTO.Employee;

/**
 * Servlet implementation class GetCityServlet
 */
@WebServlet(name = "GetCityServlet", urlPatterns = { "/getCity" })
public class GetCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCityServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Employee> empList = new ArrayList<Employee>();
		List<City> cityList = new ArrayList<City>();
		String city = request.getParameter("citySearch");

		try {
			Connection con = ConnectionProvider.getConnection();
			Statement stmt = con.createStatement();
			String query = "select Emp_name , City_name from emp_address a inner join employee e on  a.emp_id  = e.Emp_id "
					+ "inner join cities c on a.city_id = c.City_id where c.City_name = " + "'" + city + "'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Employee emp = new Employee();
				City c = new City();

				emp.setEmpName(rs.getString(EMP_NAME));
				c.setCityName(rs.getString(CITY_NAME));
				empList.add(emp);
				cityList.add(c);

			}
			request.setAttribute("empList", empList);
			request.setAttribute("cityList", cityList);
			request.getRequestDispatcher("employee/empCity.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
